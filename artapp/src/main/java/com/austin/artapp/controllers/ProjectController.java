package com.austin.artapp.controllers;

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

import com.austin.artapp.models.Project;
import com.austin.artapp.models.User;
import com.austin.artapp.services.ProjectService;
import com.austin.artapp.services.UserService;

@Controller
public class ProjectController {
	@Autowired
	private UserService userService;
	@Autowired
	private ProjectService projService;

//		Dash board Routes - TO MAIN PAGE
		@GetMapping("/home")
		public String dashboard(Model model, HttpSession session, @ModelAttribute("project") Project project) {
			if(session.getAttribute("userId")!=null) {
				User user=userService.findUserById((Long)session.getAttribute("userId"));
				model.addAttribute("user", user);
				model.addAttribute("allProjects", this.projService.allProjects());
				return "home.jsp";
			} else {
				return "redirect:/";
			}
		}
		
//		Create - GETTING TO CREATION PAGE (Get)
		@GetMapping("/projects/new")
		public String newProject(@ModelAttribute("project") Project project, HttpSession session) {
			if(session.getAttribute("userId")!=null) {
				return "new.jsp";
			} else {
				return "redirect:/";
			}
		}
		
//		Create - POSTING A NEW PROJECT (Post)
		@PostMapping("/projects/new")
		public String createProject(@Valid @ModelAttribute("project") Project project, BindingResult result) {
			if(result.hasErrors()) {
				return "new.jsp";
			} else {
				this.projService.createProject(project);
				return "redirect:/home";
			}
		}
		
//		Details - GETTING TO SPECIFIC PROJECT (Get)
		@GetMapping("/projects/{id}")
		public String detailProject(Model model, @PathVariable("id") Long id, HttpSession session) {
			if(session.getAttribute("userId")!=null) {
				model.addAttribute("thisProject", this.projService.findProject(id));
				return "project.jsp";
			} else {
				return "redirect:/";
			}
		}

		
//		Edit - GETTING TO EDIT PAGE (Get)
		@GetMapping("/projects/{id}/edit")
		public String edit(Model model, @PathVariable("id") Long id, @ModelAttribute("project") Project project, HttpSession session) {
			if(session.getAttribute("userId")!=null) {
				model.addAttribute("project", this.projService.findProject(id));
				return "projectEdit.jsp";
			} else {
				return "redirect:/";
			}
		}

//		Edit - UPDATING PROJECT (Put)
		@PutMapping("/projects/{id}/edit")
		public String updateProject(@Valid @ModelAttribute("project") Project project, BindingResult result, Model model, @PathVariable("id") Long id) {
			if(result.hasErrors()) {
				model.addAttribute("project", this.projService.findProject(id));
				return "redirect:/projects/{id}/edit";
			}
			this.projService.updateProject(project);
			return "redirect:/projects/{id}";
		}
		
//		Delete - DELETING SPECIFIC PROJECT (Delete)
		@DeleteMapping("/delete/{id}")
		public String delete(Model model, @PathVariable("id") Long id) {
			this.projService.deleteProject(id);
			return "redirect:/home";
		}
		
//		MTM Like Functionality
		
//		Like Project
		@GetMapping("/like/{id}")
		public String like(@PathVariable("id") Long project_id, HttpSession session) {
			Long User_id = (Long) session.getAttribute("userId");
			User user = userService.findUserById(User_id);
			Project project = projService.findProject(project_id);
			
			projService.likeProject(project, user);
			return "redirect:/projects/{id}";
		}
		
//		Unlike Project
		@GetMapping("/unlike/{id}")
		public String unlike(@PathVariable("id") Long project_id, HttpSession session) {
			Long User_id = (Long) session.getAttribute("userId");
			User user = userService.findUserById(User_id);
			Project project = projService.findProject(project_id);
			
			projService.unlikeProject(project, user);
			return "redirect:/projects/{id}";
		}

}