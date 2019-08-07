package com.mytodoapplication.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//this is rest controller so @RestController annotation will be used instead of @Controller
//because here we are handling Rest request
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class HelloWorldController {

	// here we are using GET method
	// URI is /hello-world
	// so if soomebody goes to web browser and sends get request by /hello-world
	// then
	// we return some text to them
	// @RequestMapping(method=RequestMethod.GET,path="/hello-world")
	// or @GetMapping(path="/hello-world")
	@RequestMapping(method = RequestMethod.GET, path = "/hello-world")
	public String helloWorld() {
		return "Hello World";
	}

	@RequestMapping(method = RequestMethod.GET, path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World-Angular 7");
		//throw new RuntimeException("Some Error Occured :Please Contact to support Team");
	}

	@RequestMapping(method = RequestMethod.GET, path = "/hello-world-bean/path-variable/{name}")
	public HelloWorldBean helloWorldBeanPathVariable(@PathVariable("name") String name ) {
		return new HelloWorldBean(String.format("Hello %s Welcome ", name));
	}

} 
