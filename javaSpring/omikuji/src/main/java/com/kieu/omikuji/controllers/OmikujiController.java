package com.kieu.omikuji.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OmikujiController {
	@GetMapping("/")
	public String index() {
		return "redirect:/omikuji";
	}
	
	@GetMapping("/omikuji")
	public String form() {
		return "form.jsp";
	}
	
	@GetMapping("/omikuji/show")
	public String show() {

		return "show.jsp";
	}
	
	
	
	@PostMapping("/omikujipost")
	public String post(
			@RequestParam("number") int number, 
			@RequestParam("city") String city, 
			@RequestParam("person") String person, 
			@RequestParam("hobby") String hobby, 
			@RequestParam("living") String living, 
			@RequestParam("comment") String comment,
			HttpSession session) {
		
		session.setAttribute("numberFront", number);
		session.setAttribute("cityFront", city);
		session.setAttribute("personFront", person);
		session.setAttribute("hobbyFront", hobby);
		session.setAttribute("livingFront", living);
		session.setAttribute("commentFront", comment);
	return "redirect:/omikuji/show";
	}
}
