package com.austin.artapp.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.austin.artapp.models.Project;
import com.austin.artapp.models.User;
import com.austin.artapp.services.FilesService;
import com.austin.artapp.services.ProjectService;
import com.austin.artapp.services.UserService;

@Controller
public class ProjectController {
	@Autowired
	private UserService userService;
	@Autowired
	private ProjectService projService;
	@Autowired
	private FilesService filesService;
	
	private static String UPLOADED_IMGS = "src/main/resources/static/images/";

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
		public String createProject(@RequestParam("image_url") MultipartFile file, @RequestParam("description") String description, @RequestParam("title") String title, User user,  HttpSession session, RedirectAttributes redirectAttr) {
//			User currentUser = this.userService.findUserById((Long)session.getAttribute("userId"));
			if(file.isEmpty()) {
				redirectAttr.addFlashAttribute("message", "Field cannot be empty.");
				System.out.println("Error 2");
				return "new.jsp";  
			} 
			try {
				byte[] bytes = file.getBytes();
				Path path = Paths.get(UPLOADED_IMGS + file.getOriginalFilename());
				Files.write(path, bytes);
				String url = "/images/" + file.getOriginalFilename();
				this.projService.createProject(title, url, description, user);
				System.out.println("Error 3");
			} catch(IOException e) {
				e.printStackTrace();
				System.out.println("Error 4");
			} 
				return "redirect:/home";
		}
			
			
//		Details - GETTING TO SPECIFIC PROJECT (Get)
		@GetMapping("/projects/{id}")
		public String detailProject(Model model, @PathVariable("id") Long id, HttpSession session) {
			if(session.getAttribute("userId")!=null) {
				Long User_id = (Long) session.getAttribute("userId");
				model.addAttribute("thisProject", this.projService.findProject(id));
				model.addAttribute("user", this.userService.findUserById(User_id));
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
		public String updateProject(@Valid @ModelAttribute("project") Project project, BindingResult result, Model model, @PathVariable("id") Long id, User user, HttpSession session) {
			if(result.hasErrors()) {
				model.addAttribute("project", this.projService.findProject(id));
				return "redirect:/projects/{id}/edit";
			}
//			Project originalProject = this.projService.findProject(id);
//			Update project with each attribute at a time - update service to match.
//			Project originalProject = this.projService.findProject(id);
//			this.projService.updateProject(project.getTitle(), project.getDescription());
			// Require an updated version of updateProject that accepts Strings for title and description

			List<User> likers = project.getLikers();
			System.out.println(likers);
			this.projService.updateProject(project, user, likers);
			return "redirect:/projects/{id}";
		}
		
//		Delete - DELETING SPECIFIC PROJECT (Delete)
		@DeleteMapping("/delete/{id}")
		public String delete(Model model, @PathVariable("id") Long id) {
			this.projService.deleteProject(id);
			return "redirect:/home";
		}
		
//		File Upload
		  @GetMapping("/files/{filename:.+}")
		  @ResponseBody
		  public ResponseEntity<Resource> getFile(@PathVariable String filename) {
		    Resource file = filesService.load(filename);
		    return ResponseEntity.ok()
		        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
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