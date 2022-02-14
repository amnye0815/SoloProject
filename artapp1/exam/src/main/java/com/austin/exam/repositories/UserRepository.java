package com.austin.exam.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.austin.exam.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
//	finds user by email address:
	User findByEmail(String email);
	
//	find all
	List<User> findAll();
	
	
}
