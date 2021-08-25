package com.luv2code.springboot11employeecrud.service;

import java.util.List;

import com.luv2code.springboot11employeecrud.entity.Employee;

public interface EmployeeService {

	List<Employee> getAll();
	
	Employee get(int employeeId);
	
	void save(Employee employee);
	
	void delete(int employeeId);
	
	List<Employee> search(String searchName);
}
