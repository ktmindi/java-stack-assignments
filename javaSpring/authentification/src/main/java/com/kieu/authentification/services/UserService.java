package com.kieu.authentification.services;

//import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;

import com.kieu.authentification.models.LoginUser;
import com.kieu.authentification.models.User;
import com.kieu.authentification.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
    private UserRepository usRe;
	
	//validate user for - duplicate email and password mismatch
	public void validate(User newUser, Errors errors) {
		//password matching
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
			errors.rejectValue("password","Mismatch", "Password does not match");
		}
		//email duplicate
		if(usRe.findByEmail(newUser.getEmail())!=null) {
			errors.rejectValue("email", "unique", "email is already taken");
		}
	}
	
	
	//hash user's password and add to data base
    public User registerUser(User newUser, BindingResult result) {
    	String hashedPass=BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    	newUser.setPassword(hashedPass);
    	usRe.save(newUser);
    	return null;  	
    }

    
    //find user by email
    public User findByEmail(String email) {
    		return usRe.findByEmail(email);
    }
    //public User login(LoginUser newLogin, BindingResult result) {
    	//	Optional<User> potentialUser = usRe.findByEmail(newLogin.getEmail());
    //    if(!potentialUser.isPresent()) {
    	//		result.rejectValue("email", "Matches", "User not found!");
    	//		return null;
    //    }
    //    User user = potentialUser.get();
    //    if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
    	//    		result.rejectValue("password", "Matches", "Invalid Password!");
    	//	}
    	
    //		if(result.hasErrors()) {
    	//		return null;
    	//	}
   //     return user;
  //  }
    	
    	
    //find user by id
    
    public User findById(Long id) {
    		return usRe.findById(id).orElse(null);
    }
   // public User findById(Long id) {
   // 		Optional<User> potentialUser = usRe.findById(id);
    //		if(potentialUser.isPresent()) {
   // 			return potentialUser.get();
   // 		}
  //  		return null;
    //}
    
    //authentification of user --login side 
    public boolean authenticateUser(LoginUser newLogin, Errors errors) {
    		//first check the email -- find the user by email
    		User user= usRe.findByEmail(newLogin.getEmail());
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

