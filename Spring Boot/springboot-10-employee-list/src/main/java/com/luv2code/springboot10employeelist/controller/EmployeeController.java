package com.luv2code.springboot10employeelist.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springboot10employeelist.entity.Employee;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	private List<Employee> employees = new ArrayList<>();
	
	{
		employees = Arrays.asList(new Employee("Nguyen", "Huy", "duonghuy@gmail.com"),
							  	  new Employee("Le", "Ngan", "ngankhung@gmail.com"),
								  new Employee("Duong", "Li", "duongli@gmail.com"),
								  new Employee("Tran", "Khoai", "duonghuy@gmail.com"),
								  new Employee("Phan", "Quyen", "duonghuy@gmail.com"));
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("employees", employees);
		return "employee-list";
	}
}
