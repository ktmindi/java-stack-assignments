package com.kieu.authentification.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
  
    public User() {}
    
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
    
    // TODO - Don't forget to generate getters and setters
  
}
    