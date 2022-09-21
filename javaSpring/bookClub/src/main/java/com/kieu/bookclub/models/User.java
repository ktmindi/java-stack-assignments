package com.kieu.bookclub.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
    
@Entity
@Table(name="users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty(message="username cannot be left blank")
    @Size(min=3, max=30, message="username must be between 3 and 30 characters")
    private String userName;
    
    @NotEmpty(message="email cannot be left blank")
    @Email(message="enter a valid email")
    private String email;
    
    @NotEmpty(message="password cannot be left blank")
    @Size(min=8, max=128, message="password must be between 8 and 128 characters")
    private String password;
    
    @Transient
    @NotEmpty(message="please confirm password")
    @Size(min=8, max=128, message="Confirm password must be between 8 and 128 characters")
    private String confirm;
  
    //first we need to define the relationship 
    //set getters and setters AFTER relationship is established
    @OneToMany(mappedBy ="user", fetch=FetchType.EAGER)
    private List<Book> books;
    
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name = "likes",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "book_id")
	)
	private List<Book> bookLiked;
    
    
    public User() {}
    
    

	public User(Long id, String userName, String email, String password, String confirm, List<Book> books, List<Book> bookLiked) {
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.confirm = confirm;
		this.books = books;
		this.bookLiked = bookLiked;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setProjects(List<Book> books) {
		this.books = books;
	}

	public List<Book> getBookLiked() {
		return bookLiked;
	}

	public void setBookLiked(List<Book> bookLiked) {
		this.bookLiked = bookLiked;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
    
	
}
    
