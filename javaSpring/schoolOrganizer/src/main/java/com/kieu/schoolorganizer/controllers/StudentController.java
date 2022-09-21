package com.kieu.schoolorganizer.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kieu.schoolorganizer.models.Student;
import com.kieu.schoolorganizer.services.StudentService;

@Controller
@RequestMapping("student")
public class StudentController {

	@Autowired
	private StudentService service;
	
	@GetMapping("")
	public String home( Model model, HttpSession session) {
		
		if ( session.getAttribute("user") == null ) return "redirect:/";
		
		model.addAttribute("students", this.service.all()); // add a breakpoint to this line to look into students
		
		return "student/list.jsp";
	}
	
	@GetMapping("/add")
    public String getAddForm(@ModelAttribute("student") Student student) {
		
        return "student/add.jsp";
    }
	
	@PostMapping("/add")
	public String add(
			@Valid @ModelAttribute("student") Student student,
			BindingResult result,
			RedirectAttributes redirectAttributes,
			HttpSession session
			) {
		
		// check for form errors
		if ( result.hasErrors() ) return "student/add.jsp";
		
		this.service.create(student);
		
		redirectAttributes.addFlashAttribute("message", "student has been added");
		
		return "redirect:/student";
	}
	
	@GetMapping("/{id}")
	public String viewItem (
			HttpSession session,
			@PathVariable Long id,
			Model model
			) {
		
		model.addAttribute("student", this.service.retrieve(id));
		
		return "student/view.jsp";
	}

	
	@GetMapping("/delete/{id}")
	public String delete(
			@PathVariable Long id,
			RedirectAttributes redirectAttributes
			) {
		
		this.service.delete(id);
		
		redirectAttributes.addFlashAttribute("message", "student has been deleted");
		
		return "redirect:/student";
	}
	
	@GetMapping("/update/{id}")
    public String getUpdateForm(Model model, @PathVariable Long id) {
			
			model.addAttribute("student", this.service.retrieve(id));
			
            return "student/update.jsp";
    }

	@PostMapping("/update")
	public String update(
			@Valid @ModelAttribute("student") Student student,
			BindingResult result,
			RedirectAttributes redirectAttributes) {
		
		if ( result.hasErrors() ) return "student/update.jsp";
		
		this.service.update(student);
		
		redirectAttributes.addFlashAttribute("message", "student has been updated");
		
		return "redirect:/student";
	}
	
	
}