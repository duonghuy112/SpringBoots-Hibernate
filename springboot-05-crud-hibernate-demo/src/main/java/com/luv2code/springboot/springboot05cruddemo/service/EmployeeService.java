package com.luv2code.springboot.springboot05cruddemo.service;

import java.util.List;

import com.luv2code.springboot.springboot05cruddemo.entity.Employee;

public interface EmployeeService {

	List<Employee> getAll();
	
	Employee get(int id);
	
	void save(Employee employee);
	
	void delete(int id);
}
