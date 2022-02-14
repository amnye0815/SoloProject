package com.austin.exam.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.austin.exam.models.Idea;
import com.austin.exam.models.User;
import com.austin.exam.services.IdeaService;
import com.austin.exam.services.UserService;
import com.austin.exam.validator.UserValidator;

@Controller
public class HomeController {
	@Autowired
	private UserService userService;
	@Autowired
	private IdeaService ideaService;
	@Autowired
	private UserValidator userValidator;
	
//	USER CONTROLLER:
//	home - LOGIN/REGISTRATION PAGE
	@GetMapping("/")
	public String index(@ModelAttribute("user") User user) {
		return "index.jsp";
	}
	
//	Register - NEW USER
	@PostMapping("/registration")
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		userValidator.validate(user, result);
		if(result.hasErrors()) {
			return "index.jsp";
		} else {
			User newUser = userService.registeredUser(user);
			session.setAttribute("userId", newUser.getId());
			return "redirect:/ideas";
		}
	}
	
//	Login - RETURNING USER
	@PostMapping("/login")
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session, RedirectAttributes redirectAttributes) {
		if(userService.authenticateUser(email, password)) {
			User user = userService.findByEmail(email);
			session.setAttribute("userId", user.getId());
			return "redirect:/ideas";
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
	
//	Idea CONTROLLER:
//	Dash board Routes - TO MAIN PAGE
	@GetMapping("/ideas")
	public String dashboard(Model model, HttpSession session, @ModelAttribute("idea") Idea idea) {
		if(session.getAttribute("userId")!=null) {
			User user=userService.findUserById((Long)session.getAttribute("userId"));
			model.addAttribute("user", user);
			model.addAttribute("allIdeas", this.ideaService.allIdeas());
			return "dashboard.jsp";
		} else {
			return "redirect:/";
		}
	}
	
//	Create - GETTING TO CREATION PAGE (Get)
	@GetMapping("/ideas/new")
	public String newidea(@ModelAttribute("idea") Idea idea, HttpSession session) {
		if(session.getAttribute("userId")!=null) {
			return "new.jsp";
		} else {
			return "redirect:/";
		}
	}
	
//	Create - POSTING A NEW idea (Post)
	@PostMapping("/ideas/new")
	public String createIdea(@Valid @ModelAttribute("idea") Idea idea, BindingResult result) {
		if(result.hasErrors()) {
			return "new.jsp";
		} else {
			this.ideaService.createIdea(idea);
			return "redirect:/ideas";
		}
	}
	
//	Details - GETTING TO SPECIFIC idea (Get)
	@GetMapping("/ideas/{id}")
	public String detailIdea(Model model, @PathVariable("id") Long id, HttpSession session) {
		if(session.getAttribute("userId")!=null) {
			model.addAttribute("thisIdea", this.ideaService.findIdea(id));
			return "details.jsp";
		} else {
			return "redirect:/";
		}
	}

	
//	Edit - GETTING TO EDIT PAGE (Get)
	@GetMapping("/ideas/{id}/edit")
	public String edit(Model model, @PathVariable("id") Long id, @ModelAttribute("idea") Idea idea, HttpSession session) {
		if(session.getAttribute("userId")!=null) {
			model.addAttribute("idea", this.ideaService.findIdea(id));
			return "edit.jsp";
		} else {
			return "redirect:/";
		}
	}

//	Edit - UPDATING idea (Put)
	@PutMapping("/ideas/{id}/edit")
	public String update(@Valid @ModelAttribute("idea") Idea idea, BindingResult result, Model model, @PathVariable("id") Long id) {
		if(result.hasErrors()) {
			model.addAttribute("idea", this.ideaService.findIdea(id));
			return "redirect:/ideas/{id}/edit";
		}
		this.ideaService.updateIdea(idea);
		return "redirect:/ideas/{id}";
	}
	
//	Delete - DELETING SPECIFIC idea (Delete)
	@DeleteMapping("/delete/{id}")
	public String delete(Model model, @PathVariable("id") Long id) {
		this.ideaService.deleteIdea(id);
		return "redirect:/ideas";
	}
	
//	MTM Like Functionality
	
//	Like idea
	@GetMapping("/like/{id}")
	public String like(@PathVariable("id") Long idea_id, HttpSession session) {
		Long User_id = (Long) session.getAttribute("userId");
		User user = userService.findUserById(User_id);
		Idea idea = ideaService.findIdea(idea_id);
		
		ideaService.likeIdea(idea, user);
		return "redirect:/ideas";
	}
	
//	Unlike idea
	@GetMapping("/unlike/{id}")
	public String unlike(@PathVariable("id") Long idea_id, HttpSession session) {
		Long User_id = (Long) session.getAttribute("userId");
		User user = userService.findUserById(User_id);
		Idea idea = ideaService.findIdea(idea_id);
		
		ideaService.unlikeIdea(idea, user);
		return "redirect:/ideas";
	}
}

