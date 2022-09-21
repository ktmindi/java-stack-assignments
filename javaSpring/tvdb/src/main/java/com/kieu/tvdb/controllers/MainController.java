package com.kieu.tvdb.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.kieu.tvdb.models.Tv;
import com.kieu.tvdb.models.LoginUser;
import com.kieu.tvdb.models.Rating;
import com.kieu.tvdb.models.User;
import com.kieu.tvdb.services.TvService;
import com.kieu.tvdb.services.UserService;
@Controller
public class MainController {

	@Autowired
	private TvService tServ;
	
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
		return "redirect:/shows";
	}

	@PostMapping("/login") 
	public String login(@Valid @ModelAttribute("newLoginView") LoginUser logU, BindingResult result, HttpSession session, @ModelAttribute("newUserView")User user) {
	 //authenticate user
		usServ.authenticateUser(logU, result);
		if(result.hasErrors()) {
			return "login.jsp";
		}
		User loggedInUser= usServ.findByEmail(logU.getEmail());
		
		session.setAttribute("loggedInUser", loggedInUser);
		return "redirect:/shows";

	}

	
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}	
	
	@GetMapping("/shows")
	public String dashboard(HttpSession session, Model tvModel) {
		//check if user is in session
		if(session.getAttribute("loggedInUser")!=null) {
			User user=(User)session.getAttribute("loggedInUser");
			User thisUser = usServ.findById(user.getId());
			tvModel.addAttribute("tv", tServ.allTvs());
			tvModel.addAttribute("thisUserView",thisUser);
			return "home.jsp";
		} else {
		return "redirect:/";
		}
	}
//remember to check if user is in session for all get routes 
//new book post 
	@GetMapping("/shows/new")
	public String newTv(HttpSession session, @ModelAttribute("newTvView") Tv tv) {
		if(session.getAttribute("loggedInUser")!=null) {
			return "add.jsp";
		}
		else {
			return "redirect:/";
		}
	}
	
	@PostMapping("/shows/new")
	public String adTv(@Valid @ModelAttribute("newTvView") Tv tv, BindingResult result) {
		if(result.hasErrors()) {
			return "add.jsp";
		} else {
			tServ.addTv(tv);
			return "redirect:/shows";
		}
	}
	
// get details about project using the link from the dashboard
	@GetMapping("/shows/{id}")
	public String tvDetail(@PathVariable Long id, Model tvModel, HttpSession session, @ModelAttribute("newRating")Rating rating) {
		if(session.getAttribute("loggedInUser")!=null) {
			Tv myTv = tServ.getOneTv(id);
			tvModel.addAttribute("tv", myTv);
			return "show.jsp";
		} else {
			return "redirect:/";
		}
	}
	
	@DeleteMapping("/shows/{id}/delete")
	public String deleteTv(@PathVariable("id") Long id) {	
			tServ.deleteTv(id);
			return "redirect:/shows";
	}
	
	@GetMapping("/shows/{id}/edit")
	public String editTv(@PathVariable Long id, Model tvModel, HttpSession session) {
		if(session.getAttribute("loggedInUser")!=null) {
			Tv myTv = tServ.getOneTv(id);
			tvModel.addAttribute("tv", myTv);
			return "edit.jsp";
		} else {
			return "redirect:/shows";
		}
	}
	
	@PutMapping("/shows/{id}/edit")
	public String updateTv(@Valid @ModelAttribute("tv")Tv tv, BindingResult result) {
		//tServ.validT(tv, result);
		if(result.hasErrors()) {
			return "edit.jsp";
		}else {
			tServ.updateTv(tv);
			return "redirect:/shows";
		}
	}
	
	//like book
	//@GetMapping("/books/{id}/like")
	//public String likeBook(@PathVariable Long id, HttpSession session) {
	//	Book book=bkServ.getOneBook(id);
	//	User user=(User)session.getAttribute("loggedInUser");
	//	User thisUser = usServ.findById(user.getId());
	//	bkServ.likeBook(book, thisUser);
	//	return "redirect:/books";
	//}
	
	//unlike book can do post or put mapping too we would just have to create buttons 
	//@GetMapping("/books/{id}/unlike")
	//public String unlikeBook(@PathVariable Long id, HttpSession session) {
	//	Book book=bkServ.getOneBook(id);
	//	User user=(User)session.getAttribute("loggedInUser");
	//	User thisUser = usServ.findById(user.getId());
	//	bkServ.unlikeBook(book, thisUser);
	//	return "redirect:/books";
	//}
	
	
	//add rating 
//	@PostMapping("/shows/rating")
//	public String addRating(@ModelAttribute("newRating") Rating rating, BindingResult result) {
	//	if(result.hasErrors()) {
	//		return "show.jsp";
	//	} else {
	//		tServ.createRating(rating);
	//		return "redirect:/shows";
	//	}
	//}
}
