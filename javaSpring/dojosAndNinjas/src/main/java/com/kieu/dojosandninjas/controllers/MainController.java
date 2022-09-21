package com.kieu.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.kieu.dojosandninjas.models.Dojo;
import com.kieu.dojosandninjas.models.Ninja;
import com.kieu.dojosandninjas.services.MainService;

@Controller

public class MainController {
	@Autowired
	private MainService mainSe;
	
	
	@GetMapping("/")
	public String homeOne() {
		return "redirect:/dojos";
	}
	
	@GetMapping("/ninjas")
	public String homeTwo() {
		return "redirect:/dojos";
	}
	
	@GetMapping("/dojos")
	public String manyDojo(@ModelAttribute("oneDojo")Dojo dojo, Model model)
	{	
		List<Dojo> manyDojo = this.mainSe.allDojo();
		model.addAttribute("listDojos", manyDojo);
		return "home.jsp";
	}

	
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("oneDojo")Dojo dojo) {
		
		return "newdojo.jsp";
	}
	
	@PostMapping("/dojos/new")
	public String addDojo(@Valid @ModelAttribute("oneDojo") Dojo dojo, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("manyDojo", mainSe.allDojo());
			return "newdojo.jsp";
		} else {
			mainSe.addDojo(dojo);
			return "redirect:/dojos";
		}
	}
	
	@GetMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("oneNinja")Ninja ninja, Model model) {
		List<Dojo> manyDojo = this.mainSe.allDojo();
		model.addAttribute("manyDojo", manyDojo);
		return "newninja.jsp";
	}
	
	@PostMapping("/ninjas/new")
	public String addNinjas (@Valid @ModelAttribute("oneNinja")Ninja ninja, BindingResult result, Model model) {
		model.addAttribute("manyDojo", mainSe.allDojo());
		if(result.hasErrors()) {
			return "newninja.jsp";
		}else {
			mainSe.addNinja(ninja);
			return "redirect:/dojos";   
//ninja.getDojo().getId();
		}
	}
	
	
	@GetMapping("/dojos/{id}")
	public String findByDojo(@PathVariable("id")Long id, Model model) {
		
		model.addAttribute("findDojo", mainSe.findDojo(id));
		return "ninjabydojo.jsp";
	}
	

}
	

