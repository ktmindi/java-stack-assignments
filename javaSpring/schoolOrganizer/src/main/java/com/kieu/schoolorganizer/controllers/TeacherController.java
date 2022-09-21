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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kieu.schoolorganizer.models.Teacher;
import com.kieu.schoolorganizer.services.StudentService;
import com.kieu.schoolorganizer.services.TeacherService;

@Controller
@RequestMapping("teacher")
public class TeacherController {

	@Autowired
	private TeacherService service;
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("")
	public String home( Model model, HttpSession session) {
		
		if ( session.getAttribute("user") == null ) return "redirect:/";
		
		model.addAttribute("teachers", this.service.all()); // add a breakpoint to this line to look into Teachers
		
		return "teacher/list.jsp";
	}
	
	@GetMapping("/add")
    public String getAddForm(@ModelAttribute("teacher") Teacher teacher) {
		
        return "teacher/add.jsp";
    }
	
	@PostMapping("/add")
	public String add(
			@Valid @ModelAttribute("teacher") Teacher teacher,
			BindingResult result,
			RedirectAttributes redirectAttributes,
			HttpSession session
			) {
		
		// check for form errors
		if ( result.hasErrors() ) return "teacher/add.jsp";
		
		this.service.create(teacher);
		
		redirectAttributes.addFlashAttribute("message", "Teacher has been added");
		
		return "redirect:/teacher";
	}
	
	@GetMapping("/{id}")
	public String viewItem (
			HttpSession session,
			@PathVariable Long id,
			Model model
			) {
		
		model.addAttribute("teacher", this.service.retrieve(id));
		
		return "teacher/view.jsp";
	}

	
	@GetMapping("/delete/{id}")
	public String delete(
			@PathVariable Long id,
			RedirectAttributes redirectAttributes
			) {
		
		this.service.delete(id);
		
		redirectAttributes.addFlashAttribute("message", "Teacher has been deleted");
		
		return "redirect:/teacher";
	}
	
	@GetMapping("/update/{id}")
    public String getUpdateForm(Model model, @PathVariable Long id) {
			
			model.addAttribute("teacher", this.service.retrieve(id));
			model.addAttribute("students", this.studentService.all());
			
            return "teacher/update.jsp";
    }

	@PostMapping("/update")
	public String update(
			@Valid @ModelAttribute("teacher") Teacher teacher,
			BindingResult result,
			RedirectAttributes redirectAttributes) {
		
		if ( result.hasErrors() ) return "teacher/update.jsp";
		
		this.service.update(teacher);
		
		redirectAttributes.addFlashAttribute("message", "Teacher has been updated");
		
		return "redirect:/teacher";
	}
	
	@PostMapping("/add-student/{teacherId}")
	public String addStudent(
			@PathVariable Long teacherId,
			@RequestParam(value="student_id") Long studentId,
			RedirectAttributes redirectAttributes) {
		
		if ( this.service.attachStudent(teacherId, studentId) != null ) {
			
			redirectAttributes.addFlashAttribute("message", "student has been added");
			
		} else {
			
			redirectAttributes.addFlashAttribute("message", "student could not be added");
			
		}
		
		return String.format("redirect:/teacher/update/%d", teacherId); // add the ID of the school being updated	
	}
	
	@GetMapping("/remove-student/{teacherId}/{studentId}")
	public String removeStudent(
			@PathVariable Long teacherId,
			@PathVariable Long studentId,
			RedirectAttributes redirectAttributes
			) {
		
		if ( this.service.detachStudent(teacherId, studentId) ) {
			
			redirectAttributes.addFlashAttribute("message", "student has been removed");
			
		} else {
			
			redirectAttributes.addFlashAttribute("message", "student could not be removed");
			
		}
		
		return String.format("redirect:/teacher/update/%d", teacherId);
	}
}