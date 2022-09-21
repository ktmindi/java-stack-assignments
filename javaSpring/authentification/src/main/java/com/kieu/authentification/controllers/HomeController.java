package com.kieu.authentification.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kieu.authentification.models.LoginUser;
import com.kieu.authentification.models.User;
import com.kieu.authentification.services.UserService;



@Controller
public class HomeController {
 
	@Autowired
	private UserService usServ;
 
	@GetMapping("/")
	public String index(
			@ModelAttribute("newUserView") User user, 
			@ModelAttribute("newLoginView") LoginUser logU) {
		return "login.jsp";
	}
 
 //remember we have to validate user, register user, then put user in session
	@PostMapping("/register")
	public String register(
			@Valid @ModelAttribute("newUserView") User user, 
			BindingResult result, 
			HttpSession session, 
			@ModelAttribute("newLoginView") LoginUser logU) {
	 //validate user
		usServ.validate(user, result);
		if(result.hasErrors()) {
         return "login.jsp";
		}
     //register user
		usServ.registerUser(user, result);
     
     //put user in session
		session.setAttribute("loggedInUser", user);
		return "redirect:/home";
	}
 
	////remember to always put what youre validating right after it and always put binding result following what you are validating or it will not show you errors and will cause problems with your models regis and login look the same except for what you are validating for each
	
	@PostMapping("/login") 
	public String login(
			@Valid @ModelAttribute("newLoginView") LoginUser logU, 
			BindingResult result, 
			HttpSession session, 
			@ModelAttribute("newUserView")User user) {
     //authenticate user
		usServ.authenticateUser(logU, result);
		if(result.hasErrors()) {
			return "login.jsp";
		}
		User loggedInUser= usServ.findByEmail(logU.getEmail());
	
		//put user in session
		
		session.setAttribute("loggedInUser", loggedInUser);
		return "redirect:/home";
     // Add once service is implemented:
     // User user = userServ.login(newLogin, result);
	}
 
     // No errors! 
     // TO-DO Later: Store their ID from the DB in session, 
     // in other words, log them in.

	
 
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}	
	
	@GetMapping("/home")
	public String dashboard(HttpSession session) {
		//check if user is in session
		if(session.getAttribute("loggedInUser")!=null) {
			return "home.jsp";
		} else {
		return "redirect:/";
		}
	}
}
	
	
 
