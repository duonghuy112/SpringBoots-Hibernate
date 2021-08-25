package com.luv2code.springboot11employeecrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springboot11employeecrud.entity.Employee;
import com.luv2code.springboot11employeecrud.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("employees", employeeService.getAll());
		return "employee-list";
	}
	
	@GetMapping("/new-employee")
	public String addEmployee(Model model) {
		model.addAttribute("employee", new Employee());
		return "employee-form";
	}
	
	@GetMapping("/update-employee")
	public String updateEmployee(@RequestParam(name = "employeeId") int employeeId, Model model) {
		model.addAttribute("employee", employeeService.get(employeeId));
		return "employee-form";
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam(name = "employeeId")int employeeId) {
		employeeService.delete(employeeId);
		return "redirect:/employee/list";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute(name = "employee") Employee employee) {
		employeeService.save(employee);
		return "redirect:/employee/list";
	}
	
	@PostMapping("/search")
	public String searchEmployee(@RequestParam(name = "searchName") String searchName, Model model) {
		model.addAttribute("employees", employeeService.search(searchName));
		return "employee-list";
	}
}
