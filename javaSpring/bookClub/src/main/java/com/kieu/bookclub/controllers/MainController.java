package com.kieu.bookclub.controllers;

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

import com.kieu.bookclub.models.Book;
import com.kieu.bookclub.models.LoginUser;
import com.kieu.bookclub.models.User;
import com.kieu.bookclub.services.BooksService;
import com.kieu.bookclub.services.UserService;
@Controller
public class MainController {

	@Autowired
	private BooksService bkServ;
	
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
		return "redirect:/books";
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
		return "redirect:/books";

	}

	
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}	
	
	@GetMapping("/books")
	public String dashboard(HttpSession session, Model bookModel) {
		//check if user is in session
		if(session.getAttribute("loggedInUser")!=null) {
			User user=(User)session.getAttribute("loggedInUser");
			User thisUser = usServ.findById(user.getId());
			bookModel.addAttribute("books", bkServ.allBooks());
			bookModel.addAttribute("thisUserView",thisUser);
			return "home.jsp";
		} else {
		return "redirect:/";
		}
	}
//remember to check if user is in session for all get routes 
//new book post 
	@GetMapping("/books/new")
	public String newBook(HttpSession session, @ModelAttribute("newBookView") Book book) {
		if(session.getAttribute("loggedInUser")!=null) {
			return "add.jsp";
		}
		else {
			return "redirect:/";
		}
	}
	
	@PostMapping("/books/new")
	public String adBook(@Valid @ModelAttribute("newBookView") Book book, BindingResult result) {
		if(result.hasErrors()) {
			return "add.jsp";
		} else {
			bkServ.addBook(book);
			return "redirect:/books";
		}
	}
	
// get details about project using the link from the dashboard
	@GetMapping("/books/{id}")
	public String bkDetail(@PathVariable Long id, Model bookModel, HttpSession session) {
		if(session.getAttribute("loggedInUser")!=null) {
			Book myBook = bkServ.getOneBook(id);
			bookModel.addAttribute("book", myBook);
			return "show.jsp";
		} else {
			return "redirect:/";
		}
	}
	
	@DeleteMapping("/books/{id}/delete")
	public String deleteBk(@PathVariable("id") Long id) {	
			bkServ.deleteBook(id);
			return "redirect:/books";
	}
	
	@GetMapping("/books/{id}/edit")
	public String editBk(@PathVariable Long id, Model bookModel, HttpSession session) {
		if(session.getAttribute("loggedInUser")!=null) {
			Book myBook = bkServ.getOneBook(id);
			bookModel.addAttribute("book", myBook);
			return "edit.jsp";
		} else {
			return "redirect:/books";
		}
	}
	
	@PutMapping("/books/{id}/edit")
	public String updateBk(@Valid @ModelAttribute("book")Book book, BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}else {
			bkServ.updateBook(book);
			return "redirect:/books";
		}
	}
	
	//like book
	@GetMapping("/books/{id}/like")
	public String likeBook(@PathVariable Long id, HttpSession session) {
		Book book=bkServ.getOneBook(id);
		User user=(User)session.getAttribute("loggedInUser");
		User thisUser = usServ.findById(user.getId());
		bkServ.likeBook(book, thisUser);
		return "redirect:/books";
	}
	
	//unlike book can do post or put mapping too we would just have to create buttons 
	@GetMapping("/books/{id}/unlike")
	public String unlikeBook(@PathVariable Long id, HttpSession session) {
		Book book=bkServ.getOneBook(id);
		User user=(User)session.getAttribute("loggedInUser");
		User thisUser = usServ.findById(user.getId());
		bkServ.unlikeBook(book, thisUser);
		return "redirect:/books";
	}
	
}
