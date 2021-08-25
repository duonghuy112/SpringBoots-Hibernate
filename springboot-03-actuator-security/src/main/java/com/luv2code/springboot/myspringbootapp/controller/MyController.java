package com.luv2code.springboot.myspringbootapp.controller;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@GetMapping("/")
	public String helloWorld() {
		return "Hello World in Spring Boot. Time is: " + LocalDateTime.now();
	}
	
	@GetMapping("/test")
	public String testDevtools() {
		return "Test DevTools";
	}
	
	@GetMapping("/fortune")
	public String fortune() {
		return "Today is a happy day";
	}
}
