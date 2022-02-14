package com.austin.exam.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.austin.exam.models.User;
import com.austin.exam.repositories.UserRepository;

@Component
public class UserValidator implements Validator {
	
	@Autowired
	private UserRepository uRepo;

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		
		if (!user.getPasswordConfirm().equals(user.getPassword())) {
			errors.rejectValue("passwordConfirm", "Match", "Passwords must match");
		}
		
		if(uRepo.findByEmail(user.getEmail())!=null) {
			errors.rejectValue("email", "unique", "Email is already registered. Please sign-in or use different email.");
		}
	}
	

}
