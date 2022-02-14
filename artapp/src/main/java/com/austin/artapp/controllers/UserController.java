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

import com.austin.artapp.models.Profile;
import com.austin.artapp.models.Project;
import com.austin.artapp.models.User;
import com.austin.artapp.services.ProfileService;
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
	private ProfileService profService;
	@Autowired
	private ProjectService projService;


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
	public String detailUser(Model model, @PathVariable("id") Long id, User user, HttpSession session, @ModelAttribute("project") Project project) {
		if(session.getAttribute("userId")!=null) {
			model.addAttribute("thisUser", this.userService.findUserById(id));
			model.addAttribute("project", this.projService.thisUsersProjects(user));
			return "profile.jsp";
		} else {
			return "redirect:/";
		}
	}
	
//	New - Getting to creation page (get)
//	@GetMapping("profiles/{id}/new")
//	public String newProfile(@ModelAttribute("profile") Profile profile, HttpSession session) {
//		if(session.getAttribute("userId")!=null) {
//			return "newProfile.jsp";
//		} else {
//			return "redirect:/home";
//		}
//	}
	
//	Create - creating new profile (post)
//	@PostMapping("profiles/{id}/new")
//	public String createProfile(@Valid @ModelAttribute("profile") Profile profile, BindingResult result) {
//		if(result.hasErrors()) {
//			return "redirect:/home";
//		} else {
//			this.profService.createProfile(profile);
//			return "profile.jsp";
//		}
//	}
	
	
//	Edit - GETTING TO EDIT PROFILE PAGE (Get)
	@GetMapping("/profiles/{id}/edit")
	public String editUser(Model model, @ModelAttribute("user") User user, @ModelAttribute("profile") Profile profile, @PathVariable("id") Long id, HttpSession session) {
		if(session.getAttribute("userId")!=null) {
			model.addAttribute("thisUser", this.userService.findUserById(id));
			model.addAttribute("thisProfile", this.profService.findProfile(id));
			return "profileEdit.jsp";
		} else {
			return "redirect:/";
		}
	}
	
//	UPDATE - UPDATING PROFILE (Put)
	@PutMapping("/profiles/{id}/edit")
	public String updateUser(@Valid @ModelAttribute("user") User user, @ModelAttribute("profile") Profile profile, Model model, @PathVariable("id") Long id) {
		model.addAttribute("user", this.userService.findUserById(id));
		model.addAttribute("profile", this.profService.findProfile(id));
		this.profService.updateProfile(profile);
		return "redirect:/profiles/{id}";
	}
	
}