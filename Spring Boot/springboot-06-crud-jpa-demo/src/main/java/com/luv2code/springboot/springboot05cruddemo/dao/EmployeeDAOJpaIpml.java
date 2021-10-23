package com.luv2code.springboot.springboot05cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.springboot05cruddemo.entity.Employee;

@Repository
public class EmployeeDAOJpaIpml implements EmployeeDAO {
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Employee> getAll() {
		return entityManager.createQuery("from Employee", Employee.class).getResultList();
	}
	
	@Override
	public Employee get(int id) {
		return entityManager.find(Employee.class, id);
	}
	
	@Override
	public void save(Employee employee) {
		entityManager.merge(employee);
	}

	@Override
	public void delete(int id) {
		entityManager.remove(get(id));
	}
}
