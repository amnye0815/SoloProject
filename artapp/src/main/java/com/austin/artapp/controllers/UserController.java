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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.austin.artapp.models.Project;
import com.austin.artapp.models.User;
import com.austin.artapp.services.ProjectService;
import com.austin.artapp.services.UserService;
import com.austin.artapp.validator.UserValidator;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private UserValidator userValidator;
	@Autowired
	private ProjectService projService;


//	home - LOGIN/REGISTRATION PAGE
	@GetMapping("/")
	public String login(@ModelAttribute("user") User user) {
		return "login-toggle.jsp";
	}
	
	@GetMapping("/register")
	public String register(@ModelAttribute("user") User user) {
		return "register.jsp";
	}
	
	@GetMapping("/login-toggle")
	public String loginToggle(@ModelAttribute("user") User user) {
		return "login-toggle.jsp";
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
	public String detailUser(Model model, @PathVariable("id") Long id, User user, HttpSession session, @ModelAttribute("project") Project project) {
		if(session.getAttribute("userId")!=null) {
			model.addAttribute("thisUser", this.userService.findUserById(id));
			model.addAttribute("project", this.projService.thisUsersProjects(user));
			return "profile.jsp";
		} else {
			return "redirect:/";
		}
	}
}