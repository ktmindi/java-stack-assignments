package com.kieu.bookclub.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.kieu.bookclub.models.Book;
import com.kieu.bookclub.models.User;
import com.kieu.bookclub.repositories.BookRepository;

@Service
public class BooksService {
	@Autowired
	private BookRepository bRepo;
	
	//standard CRUD services needed
	
	//list all books
	public List<Book> allBooks() {
		return bRepo.findAll();
	}
	
	//create new book post
	public Book addBook(Book book) {
		return bRepo.save(book);
	}
	
	//delete a book post
	public void deleteBook(Long id) {
		bRepo.deleteById(id);
	}
	
	//get one book by id
	public Book getOneBook(Long id) {
		return bRepo.findById(id).orElse(null);
	}
	
	//update a book post
	public Book updateBook(Book book) {
		return bRepo.save(book);
	}
	
	
	//these additional methods can be placed in either of the service files 
	//business logic doesnt change
	//like
	

	public void likeBook(Book book, User user) {
		List<User> likers = book.getLikers();
		likers.add(user);
		bRepo.save(book);
		
	}
	
	//unlike
	public void unlikeBook(Book book, User user) {
		List<User> likers = book.getLikers();
		likers.remove(user);
		bRepo.save(book);
		
	}
}
