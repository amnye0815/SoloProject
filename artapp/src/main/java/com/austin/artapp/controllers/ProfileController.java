package com.austin.artapp.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.austin.artapp.models.Profile;
import com.austin.artapp.models.Project;
import com.austin.artapp.models.User;
import com.austin.artapp.services.ProfileService;
import com.austin.artapp.services.UserService;

@Controller
public class ProfileController {
	@Autowired
	private UserService userService;
	@Autowired
	private ProfileService profService;

	
//	New - Getting to profile detail page (get)
	@GetMapping("profiles/{id}/new")
	public String newProfile(Model model, @PathVariable("id") Long id, User user, HttpSession session, @ModelAttribute("project") Project project, @ModelAttribute("profile") Profile profile) {
		if(session.getAttribute("userId")!=null) {
			model.addAttribute("thisUser", this.userService.findUserById(id));
			model.addAttribute("profile", this.profService.thisUsersProfile(user));
			return "profileDetail.jsp";
		} else {
			return "redirect:/home";
		}
	}
	
//	Create - creating new profile info (post)
	@PostMapping("profiles/{id}/new")
	public String createProfile(@RequestParam("age") Integer age, @RequestParam("location") String location, @RequestParam("bio") String bio, @RequestParam("media") String media, User user,  HttpSession session) {
		if(session.getAttribute("userId")!=null) {
			return "redirect:/home";
		} else {
			this.profService.createProfile(age, location, bio, media, user);
			return "profile.jsp";
		}
	}
	
	
//	Edit - GETTING TO EDIT PROFILE PAGE (Get)
	@GetMapping("/profiles/{id}/edit")
	public String editUser(Model model, @ModelAttribute("profile") Profile profile, @PathVariable("id") Long id, HttpSession session) {
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
	public String updateProfile(@ModelAttribute("profile") Profile profile, Model model, @PathVariable("id") Long id, HttpSession session) {
		if(session.getAttribute("userId")!=null) {
			model.addAttribute("thisUser", this.userService.findUserById(id));
			model.addAttribute("profile", this.profService.findProfile(id));
			this.profService.updateProfile(profile);
			return "redirect:/profiles/{id}";
		} else {
		return "redirect:/";
		}
	}
}
