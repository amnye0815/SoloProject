package com.austin.artapp.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.austin.artapp.models.Project;


@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

	
//	finds all
	List<Project> findAll();
	
}
