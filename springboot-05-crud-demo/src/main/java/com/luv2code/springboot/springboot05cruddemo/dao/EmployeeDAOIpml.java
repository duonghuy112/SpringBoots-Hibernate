package com.luv2code.springboot.springboot05cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.springboot05cruddemo.entity.Employee;

@Repository
public class EmployeeDAOIpml implements EmployeeDAO {
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Employee> getAll() {
		return entityManager.unwrap(Session.class)
							.createQuery("from Employee", Employee.class)
							.getResultList();
	}
	
	@Override
	public Employee get(int id) {
		return entityManager.unwrap(Session.class).get(Employee.class, id);
	}
	
	@Override
	public void save(Employee employee) {
		entityManager.unwrap(Session.class).saveOrUpdate(employee);
	}

	@Override
	public void delete(int id) {
		entityManager.unwrap(Session.class).delete(get(id));
	}
}
