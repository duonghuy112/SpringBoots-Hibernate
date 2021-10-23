package com.luv2code.springboot.myspringbootapp.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	
	@Value("${coach.name}")
	private String coachName;
	
	@Value("${team.name}")
	private String teamName;

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
	
	@GetMapping("/property")
	public String property() {
		return "Coach name: " + coachName + "; Team name: " + teamName;
	}
}
