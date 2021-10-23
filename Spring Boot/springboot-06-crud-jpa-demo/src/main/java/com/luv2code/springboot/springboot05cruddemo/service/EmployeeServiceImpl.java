package com.luv2code.springboot.springboot05cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.springboot05cruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.springboot05cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	@Qualifier(value = "employeeDAOJpaIpml")
	private EmployeeDAO employeeDAO;
	
	@Transactional
	@Override
	public List<Employee> getAll() {
		List<Employee> employees = employeeDAO.getAll();
		if (employees == null) {
			throw new RuntimeException();
		}
		return employees;
	}

	@Transactional
	@Override
	public Employee get(int id) {
		Employee employee = employeeDAO.get(id);
		if (employee == null) {
			throw new RuntimeException();
		}
		return employee;
	}

	@Transactional
	@Override
	public void save(Employee employee) {
		employeeDAO.save(employee);
	}

	@Transactional
	@Override
	public void delete(int id) {
		employeeDAO.delete(id);
	}

}
