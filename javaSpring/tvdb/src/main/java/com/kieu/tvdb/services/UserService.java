package com.kieu.tvdb.services;



import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;

import com.kieu.tvdb.models.User;
import com.kieu.tvdb.repositories.UserRepository;
import com.kieu.tvdb.models.LoginUser;

@Service
public class UserService {
	
	@Autowired
    private UserRepository usRepo;

	
	//validate user for - duplicate email and password mismatch
	public void validate(User newUser, Errors errors) {
		//password matching
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
			errors.rejectValue("password","Mismatch", "Password does not match");
		}
		//email duplicate
		if(usRepo.findByEmail(newUser.getEmail())!=null) {
			errors.rejectValue("email", "unique", "email is already taken");
		}
	}
	
	
	//hash user's password and add to data base
    public User registerUser(User newUser, BindingResult result) {
    	String hashedPass=BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    	newUser.setPassword(hashedPass);
    	usRepo.save(newUser);
    	return null;  	
    }

    
    //find user by email
    public User findByEmail(String email) {
    		return usRepo.findByEmail(email);
    }

    	
    //find user by id
    
    public User findById(Long id) {
    		return usRepo.findById(id).orElse(null);
    }

    
    //authentification of user --login side 
    public boolean authenticateUser(LoginUser newLogin, Errors errors) {
    		//first check the email -- find the user by email
    		User user= usRepo.findByEmail(newLogin.getEmail());
    		// if we cant find user by email return false
    		if(user==null) {
    			errors.rejectValue("email", "missingEmail", "email not found");
    			return false;
    		}else {
    			if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
    				errors.rejectValue("password","matches","invalid password");
    				return false;
    			}
    		}
    		// if user is found check if the passwords match, return true, else, return false
    		return true;
    }
}



