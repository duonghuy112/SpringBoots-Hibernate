package com.luv2code.springboot.springboot05cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.springboot05cruddemo.dao.EmployeeRepository;
import com.luv2code.springboot.springboot05cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee get(int id) {
		Optional<Employee> employee = Optional.of(employeeRepository.getById(id));
		if (employee.isPresent()) {
			return employee.get();
		} else {
			throw new RuntimeException();
		}
	}

	@Override
	public void save(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public void delete(int id) {
		employeeRepository.deleteById(id);
	}


}
