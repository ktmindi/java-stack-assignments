package com.kieu.authentification.models;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
  
//used for validating input from the login form - just like transient pw field we will never save loginuser object 
//notice no entity annotation and only has email and pw

public class LoginUser {
    
    @NotEmpty(message="email cannot be left blank")
    @Email(message="please enter a valid email")
    private String email;
    
    @NotEmpty(message="password cannot be left blank")
    @Size(min=8, max=128, message="password must be between 8 and 128 characters")
    private String password;
    
    public LoginUser() {}

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
    
    // TODO - Don't forget to generate getters and setters
    
}

