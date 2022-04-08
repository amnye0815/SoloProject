package com.austin.artapp.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.austin.artapp.models.Profile;
import com.austin.artapp.models.User;


@Repository
public interface ProfileRepository extends CrudRepository<Profile, Long> {

//	finds profile by user:
	Profile findByUser(User user_id);	
	
//	finds all
	List<Profile> findAll();
	
}
