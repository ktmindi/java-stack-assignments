package com.kieu.helloworld.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//annotation lets the app know what kind of file this is
@RestController

public class HelloWorldController {
	//this is our first route, the url is / home = variable name for the route
	// return whatever data is in quotation
	@RequestMapping("/")
	public String home() {
		return "Hello World";
	}
	
	//PATH VARIABLE 
	//we can also pass information thru the URL itself (as well as forms which we will go over later)
	@RequestMapping("/hello/{name}")
	public String helloName(@PathVariable String name) {
		return String.format("Hello %s!", name);
	}
	
	//these two annotations alone will give you an error because we don't have a path/route for "/hello/" so our route above wont get triggered
	@RequestMapping("/hello")
	public String hello() {
		return "Hello how are you doing?";
	}
	//with the addition of this now the path variable route will get triggered and can be used and tested using localhost
	
	//query variable
	//request param will 
	@RequestMapping("/hello/age/{name}")
	public String helloNameAge(@PathVariable String name, 	@RequestParam(value="age") int age) {
		return String.format("Hello %s! you are %d years old", name, age);
	} 
	//the url for this would be the following "hello/age/fred?age=34"
	//when you do a GET request you will see the info in the URL
	//when you do a POST request you wont see it cause its working in the background

}