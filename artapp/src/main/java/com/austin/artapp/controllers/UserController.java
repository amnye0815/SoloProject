package com.austin.artapp.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.austin.artapp.models.User;
import com.austin.artapp.services.UserService;
import com.austin.artapp.validator.UserValidator;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private UserValidator userValidator;


//	home - LOGIN/REGISTRATION PAGE
	@GetMapping("/")
	public String login(@ModelAttribute("user") User user) {
		return "login.jsp";
	}
	
//	Register - NEW USER
	@PostMapping("/registration")
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		userValidator.validate(user, result);
		if(result.hasErrors()) {
			return "login.jsp";
		} else {
			User newUser = userService.registeredUser(user);
			session.setAttribute("userId", newUser.getId());
			return "redirect:/home";
		}
	}
	
//	Login - RETURNING USER
	@PostMapping("/login")
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session, RedirectAttributes redirectAttributes) {
		if(userService.authenticateUser(email, password)) {
			User user = userService.findByEmail(email);
			session.setAttribute("userId", user.getId());
			return "redirect:/home";
		} else {
			redirectAttributes.addFlashAttribute("error", "Invalid user/password");
			return "redirect:/";
		}
	}
	
//	logout - INVALIDATE USER
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
//	Profile - GETTING TO SPECIFIC USER (Get)
	@GetMapping("/profiles/{id}")
	public String detailUser(Model model, @PathVariable("id") Long id, HttpSession session) {
		if(session.getAttribute("userId")!=null) {
			model.addAttribute("thisUser", this.userService.findUserById(id));
			return "profile.jsp";
		} else {
			return "redirect:/";
		}
	}
	
//	Edit - GETTING TO EDIT PROFILE PAGE (Get)
	@GetMapping("/profiles/{id}/edit")
	public String editUser(Model model, @ModelAttribute("user") User user, @PathVariable("id") Long id, HttpSession session) {
		if(session.getAttribute("userId")!=null) {
			model.addAttribute("thisUser", this.userService.findUserById(id));
			return "profileEdit.jsp";
		} else {
			return "redirect:/";
		}
	}
	
//	Edit - UPDATING PROFILE (Put)
	@PutMapping("/profiles/{id}/edit")
	public String updateUser(@Valid @ModelAttribute("user") User user, Model model, @PathVariable("id") Long id) {
//		if(result.hasErrors()) {
			model.addAttribute("user", this.userService.findUserById(id));
//			return "redirect:/profiles/{id}/edit";
//		}
		this.userService.updateUser(user);
		return "redirect:/profiles/{id}";
	}
	
}