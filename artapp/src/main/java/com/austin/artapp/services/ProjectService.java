package com.austin.artapp.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.austin.artapp.models.Project;
import com.austin.artapp.models.User;
import com.austin.artapp.repositories.ProjectRepository;




@Service
public class ProjectService {
	@Autowired
	private ProjectRepository projRepo;
	
//	find all projects:
	public List<Project> allProjects() {
		return this.projRepo.findAll();
	}
	
//	find one project:
	public Project findProject(Long id) {
		return projRepo.findById(id).orElse(null);
	}
	
//	create project:
	public Project createProject(Project project) {
		return this.projRepo.save(project);
	}
	
//	update project:
	public Project updateProject(Project project) {
		return this.projRepo.save(project);
	}
	
// delete project:
	public void deleteProject(Long id) {
		this.projRepo.deleteById(id);
	}
	
//	Like a project
	public void likeProject(Project project, User user) {
		project.getLikers().add(user);
		projRepo.save(project);
	}
	
//	Unlike a project
	public void unlikeProject(Project project, User user) {
		project.getLikers().remove(user);
		projRepo.save(project);
	}    
	
}