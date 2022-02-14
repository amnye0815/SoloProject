package com.austin.exam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.austin.exam.models.Idea;
import com.austin.exam.models.User;
import com.austin.exam.repositories.IdeaRepository;




@Service
public class IdeaService {
	@Autowired
	private IdeaRepository iRepo;
	
//	find all projects:
	public List<Idea> allIdeas() {
		return this.iRepo.findAll();
	}
	
//	find one project:
	public Idea findIdea(Long id) {
		return iRepo.findById(id).orElse(null);
	}
	
//	create project:
	public Idea createIdea(Idea project) {
		return this.iRepo.save(project);
	}
	
//	update project:
	public Idea updateIdea(Idea idea) {
		return this.iRepo.save(idea);
	}
	
// delete project:
	public void deleteIdea(Long id) {
		this.iRepo.deleteById(id);
	}
	
//	Like a project
	public void likeIdea(Idea idea, User user) {
		idea.getLikers().add(user);
		iRepo.save(idea);
	}
	
//	Unlike a project
	public void unlikeIdea(Idea idea, User user) {
		idea.getLikers().remove(user);
		iRepo.save(idea);
	}    
	
}