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

import com.kieu.schoolorganizer.models.School;
import com.kieu.schoolorganizer.services.SchoolService;
import com.kieu.schoolorganizer.services.TeacherService;

@Controller
@RequestMapping("school")
public class SchoolController {

	@Autowired
	private SchoolService service; // using generic variable names for better reusability
	
	@Autowired
	private TeacherService teacherService;
	
	@GetMapping("")
	public String home( Model model, HttpSession session) {
		
		if ( session.getAttribute("user") == null ) return "redirect:/";
		
		model.addAttribute("schools", this.service.all()); // add a breakpoint to this line to look into schools
		
		return "school/list.jsp";
	}
	
	@GetMapping("/add")
    public String getAddForm(@ModelAttribute("school") School schoool) {
		
        return "school/add.jsp";
    }
	
	@PostMapping("/add")
	public String add(
			@Valid @ModelAttribute("school") School school,
			BindingResult result,
			RedirectAttributes redirectAttributes,
			HttpSession session
			) {
		
		// check for form errors
		if ( result.hasErrors() ) return "school/add.jsp";
		
		this.service.create(school);
		
		redirectAttributes.addFlashAttribute("message", "School has been added");
		
		return "redirect:/school";
	}
	
	@GetMapping("/{id}")
	public String viewItem (
			HttpSession session,
			@PathVariable Long id,
			Model model
			) {
		
		model.addAttribute("school", this.service.retrieve(id));
		
		return "school/view.jsp";
	}

	
	@GetMapping("/delete/{id}")
	public String delete(
			@PathVariable Long id,
			RedirectAttributes redirectAttributes
			) {
		
		this.service.delete(id);
		
		redirectAttributes.addFlashAttribute("message", "School has been deleted");
		
		return "redirect:/school";
	}
	
	@GetMapping("/update/{id}")
    public String getUpdateForm(Model model, @PathVariable Long id) {
			
			model.addAttribute("school", this.service.retrieve(id));
			model.addAttribute("teachers", this.teacherService.all());
			
            return "school/update.jsp";
    }

	@PostMapping("/update")
	public String update(
			@Valid @ModelAttribute("school") School school,
			BindingResult result,
			RedirectAttributes redirectAttributes) {
		
		if ( result.hasErrors() ) return "school/update.jsp";
		
		this.service.update(school);
		
		redirectAttributes.addFlashAttribute("message", "School has been updated");
		
		return "redirect:/school";
	}
	
	@PostMapping("/add-teacher/{schoolId}")
	public String addTeacher(
			@PathVariable Long schoolId,
			@RequestParam(value="teacher_id") Long teacherId,
			RedirectAttributes redirectAttributes) {
		
		if ( this.teacherService.setSchool(schoolId, teacherId) ) {
			redirectAttributes.addFlashAttribute("message", "Teacher has been added");
			
		} else {

			redirectAttributes.addFlashAttribute("message", "Unable to add teacher");
		}
		
		return String.format("redirect:/school/update/%d", schoolId); // add the ID of the school being updated
				
	}
	
	@GetMapping("/remove-teacher/{schoolId}/{teacherId}")
	public String removeTeacher(
			@PathVariable Long schoolId,
			@PathVariable Long teacherId,
			RedirectAttributes redirectAttributes
			) {
		
		if ( this.teacherService.unsetSchool(schoolId, teacherId) ) {
			
			redirectAttributes.addFlashAttribute("message", "Teacher has been removed");
			
		} else {

			redirectAttributes.addFlashAttribute("message", "Unable to remove teacher");
			
		}
		
		return String.format("redirect:/school/update/%d", schoolId); // add the ID of the school being updated
	}
}