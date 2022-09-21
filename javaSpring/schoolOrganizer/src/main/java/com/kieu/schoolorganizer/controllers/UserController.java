package com.kieu.schoolorganizer.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kieu.schoolorganizer.models.User;
import com.kieu.schoolorganizer.repositories.UserRepository;
import com.kieu.schoolorganizer.services.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@Autowired
	private UserRepository repository;
	
	@GetMapping("/login")
	public String getLoginForm(@ModelAttribute("user") User user) {
		return "login.jsp";
	}

	@PostMapping("/login")
	public String login(
			@Valid @ModelAttribute("user") User user,
			RedirectAttributes redirectAttributes,
			HttpSession session,
			Model model
			) {
		
		user = this.service.authenticate(user);
		
		if ( user != null ) {
			
			session.setAttribute("user", user.getId());
			
			redirectAttributes.addFlashAttribute("message", String.format("Welcome back %s!", user.getEmail()));
			
			return "redirect:/";
		}
		
		model.addAttribute("message", "Invalid Credentials");
		
		return "login.jsp";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		session.removeAttribute("user");
		
		return "redirect:/";
	}
	
	@GetMapping("/register")
	public String getRegisterForm(@ModelAttribute("user") User user) {
		return "register.jsp";
	}
	
	@PostMapping("/register")
	public String register(
			@Valid @ModelAttribute("user") User user,
			BindingResult result,
			RedirectAttributes redirectAttributes) {
		
		if(!user.getPassword().equals(user.getPasswordConfirmation())) {
		    result.rejectValue("passwordConfirmation", "Matches", "The Confirm Password must match Password!");
		}
		
		if(this.repository.findByEmail(user.getEmail()).isPresent()) {
        	result.rejectValue("email", "Email", "That email address is not available.");
        }
		
		if ( result.hasErrors() ) return "register.jsp";
		
		this.service.create(user);
		
		redirectAttributes.addFlashAttribute("message", "Thank you for registering!");
		
		return "redirect:/user/login";
	}
}