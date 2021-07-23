package com.luv2code.springdemo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	@RequestMapping("processFromVersionTwo")
	public String processFromVersionTwo(HttpServletRequest request, Model model) {
		String name = request.getParameter("name");
		
		String result = "Yo! " + name.toUpperCase();
		
		model.addAttribute("mess", result);
		
		return "helloworld";
	}
	
	@RequestMapping("processFromVersionThree")
	public String processFromVersionThree(@RequestParam("name") String name, Model model) {
		String result = "Yo from v3! " + name.toUpperCase();
		
		model.addAttribute("mess", result);
		
		return "helloworld";
	}
	
	
}
