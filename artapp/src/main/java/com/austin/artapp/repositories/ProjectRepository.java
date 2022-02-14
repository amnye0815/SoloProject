package com.austin.artapp.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.austin.artapp.models.Project;
import com.austin.artapp.models.User;


@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

//	finds project by user:
	List<Project> findByUser(User user_id);
	
//	finds all
	List<Project> findAll();
	
}
