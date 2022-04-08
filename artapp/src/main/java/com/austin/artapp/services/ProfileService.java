package com.austin.artapp.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.austin.artapp.models.Profile;
import com.austin.artapp.models.User;
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
	
//	find one user's profile:
	public Profile thisUsersProfile(User id) {
		return profRepo.findByUser(id);
	}
	
//	create profile:
	public Profile createProfile(Integer age, String location, String bio, String media, User user) {
		Profile newProfile = new Profile(age, location, bio, media, user);
		return this.profRepo.save(newProfile);
	}
	
//	update profile:
	public Profile updateProfile(Profile profile) {
		System.out.println(profile.getId());
		return this.profRepo.save(profile);
	}
	
//	delete profile: 
	public void deleteProfile(Long id) {
		this.profRepo.deleteById(id);
	}
}