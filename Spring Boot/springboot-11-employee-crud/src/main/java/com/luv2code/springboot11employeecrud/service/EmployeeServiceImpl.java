package com.luv2code.springboot11employeecrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot11employeecrud.dao.EmployeeRepository;
import com.luv2code.springboot11employeecrud.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> getAll() {
		return employeeRepository.findAllByOrderByLastName();
	}

	@Override
	public Employee get(int employeeId) {
		return employeeRepository.getById(employeeId);
	}

	@Override
	public void save(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public void delete(int employeeId) {
		employeeRepository.deleteById(employeeId);
	}
	
	@Override
	public List<Employee> search(String searchName) {
		return employeeRepository.findAllByName(searchName, searchName);
	}
}
