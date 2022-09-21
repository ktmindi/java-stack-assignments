package com.kieu.todo.controllers;


import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kieu.todo.models.ToDo;


@Controller 
public class ToDoController {

	@GetMapping("/")
	public String home(
			HttpSession session, 
			Model model
			) {
		
		@SuppressWarnings("unchecked")
		ArrayList<ToDo> todos = (session.getAttribute("todos") == null) ?
				new ArrayList<ToDo>() : (ArrayList<ToDo>) session.getAttribute("todos"); 
		
		model.addAttribute("items", todos); 
		return "todo.jsp";
	}
	
	@GetMapping("/todo/add")
	public String getAddFormSession() {
		return "addToDo.jsp";
	}
	
	@PostMapping("/todo/add")
	public String addWithSession(
			@RequestParam(value="text") String text,
			RedirectAttributes redirectAttributes,
			HttpSession session
			) {
		@SuppressWarnings("unchecked")
		ArrayList<ToDo> todos = (session.getAttribute("todos") == null) ? 
				new ArrayList<ToDo>() : (ArrayList<ToDo>) session.getAttribute("todos"); //current list of todos
		
		todos.add(new ToDo(todos.size() + 1, text));  //added one to i t
		
		session.setAttribute("todos", todos);   //saved it back
		return "redirect:/";
	}

}
