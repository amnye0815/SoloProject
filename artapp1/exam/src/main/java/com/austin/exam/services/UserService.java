package com.austin.exam.services;


import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.austin.exam.models.User;
import com.austin.exam.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository uRepo;
	
	public UserService(UserRepository userRepo) {
		this.uRepo = userRepo;
	}
	
//	Register and Hash
	public User registeredUser(User user) {
		String hashedPW = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashedPW);
		return uRepo.save(user);
	}
	
//	find user by email
	public User findByEmail(String email) {
		return uRepo.findByEmail(email);
	}
	
//	find user by id
	public User findUserById(Long id) {
		return uRepo.findById(id).orElse(null);
	}
	
//	authenticate user
    public boolean authenticateUser(String email, String password) {
        // first find the user by email
        User user = uRepo.findByEmail(email);
        // if we can't find it by email, return false
        if(user == null) {
            return false;
        } else {
            // if the passwords match, return true, else, return false
            if(BCrypt.checkpw(password, user.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
    }
   
}
