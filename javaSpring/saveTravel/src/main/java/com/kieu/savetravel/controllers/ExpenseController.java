package com.kieu.savetravel.controllers;

import java.util.List;

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

import com.kieu.savetravel.models.Expense;
import com.kieu.savetravel.services.ExpenseService;

@Controller
public class ExpenseController {
	@Autowired
	private ExpenseService expServ;

	
	//redirect to home page
	@GetMapping("/")
	public String redirectHome() {
		return "redirect:/expenses";
	}
	
	
	//home page with all expenses and add form
	@GetMapping("/expenses")
	public String homePage(@ModelAttribute("oneExp") Expense exp, Model model) {
		List<Expense> manyExp = expServ.all();
		model.addAttribute("manyExp", manyExp);
		
		
		return "home.jsp";
	}
	
	
	//posting to home page
	@PostMapping("/expenses")
	public String addExpense(@Valid @ModelAttribute("oneExp") Expense exp, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("manyExp", expServ.all());
			return "home.jsp";
		}
		expServ.add(exp);
		
		return "redirect:/";
		
	}
	
	
	
	// show details by ID  -- remember expView is what variable will need to be passed into JSP page to pull the data to the jsp page -- if we now write ${expView} into our jsp page when we look at the page it will give us the url of the book. from here we need to add our model attributes ex ${expView.vendor} will give us the vendor
	@GetMapping("/expenses/{id}")
	public String showExpense(Model model, @PathVariable("id") Long id) {
		Expense exp = expServ.find(id);
		model.addAttribute("oneExp", exp);
		return "show.jsp";
	}
	
	@GetMapping("/expenses/edit")
	public String editPage() {
		return "redirect:/";
	}
	
	
	// show edit form
	@GetMapping("/expenses/edit/{id}")
	public String editExpense(@PathVariable("id") Long id, Model model) {
		Expense exp = expServ.find(id);
		model.addAttribute("oneExp", exp);
		model.addAttribute("manyExp", expServ.all());
		return "edit.jsp";
	}
	
	@PutMapping("/expenses/edit/{id}")
	public String update(@Valid @ModelAttribute("oneExp") Expense exp, BindingResult result) {
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			expServ.update(exp);
			return "redirect:/expenses";
		}
	}
	
	
	@DeleteMapping("/expenses/{id}")
	public String delete(@PathVariable("id") Long id) {
		
		expServ.delete(id);
		
		return "redirect:/expenses";
	}

}