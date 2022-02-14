package com.austin.artapp.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.austin.artapp.models.Profile;
import com.austin.artapp.repositories.ProfileRepository;




@Service
public class ProfileService {
	@Autowired
	private ProfileRepository profRepo;
	
//	find all profiles:
	public List<Profile> allprofiles() {
		return this.profRepo.findAll();
	}
	
//	find one profile:
	public Profile findProfile(Long id) {
		return profRepo.findById(id).orElse(null);
	}
	
//	create profile:
	public Profile createProfile(Profile profile) {
		return this.profRepo.save(profile);
	}
	
//	update profile:
	public Profile updateProfile(Profile profile) {
		return this.profRepo.save(profile);
	}
}