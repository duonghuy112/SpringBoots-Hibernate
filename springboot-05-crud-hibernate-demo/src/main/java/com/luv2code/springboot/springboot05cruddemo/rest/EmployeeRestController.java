package com.luv2code.springboot.springboot05cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.springboot05cruddemo.entity.Employee;
import com.luv2code.springboot.springboot05cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employees")
	public List<Employee> getAll() {
		return employeeService.getAll();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee get(@PathVariable int employeeId) {
		if (isValidId(employeeId)) {
			return employeeService.get(employeeId);
		} else {
			throw new RuntimeException();
		}
	}
	
	@PostMapping("/employees")
	public Employee add(@RequestBody Employee employee) {
		employee.setId(0);
		employeeService.save(employee);
		return employee;
	}
	
	@PutMapping("/employees")
	public Employee update(@RequestBody Employee employee) {
		employeeService.save(employee);
		return employee;
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public String delete(@PathVariable int employeeId) {
		if (isValidId(employeeId)) {
			employeeService.delete(employeeId);
			return "Deleted Employee Id: " + employeeId;
		} else {
			throw new RuntimeException();
		}
	}
	
	private boolean isValidId(int employeeId) {
		return employeeId < employeeService.getAll().size() || employeeId >= 0;
	}
	
}
