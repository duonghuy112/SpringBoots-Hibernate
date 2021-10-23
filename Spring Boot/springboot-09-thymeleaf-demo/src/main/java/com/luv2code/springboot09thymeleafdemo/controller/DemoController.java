package com.luv2code.springboot09thymeleafdemo.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	@GetMapping("/hello")
	public String sayHello(Model model) {
		model.addAttribute("time", LocalDateTime.now());
		return "hello";
	}
}
