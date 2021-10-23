package com.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@GetMapping("/showLoginPage")
	public String showLoginPage() {
		return "fancy-login";
	}
	
	@RequestMapping("/access-denied")
	public String accessDenied() {
		return "access-denied";
	}
}
