package com.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springdemo.dao.CustomerDAO;
import com.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;
	
	@Transactional
	@Override
	public List<Customer> getAll() {
		return customerDAO.getAll();
	}
	
	@Transactional
	@Override
	public List<Customer> get(String name) {
		return customerDAO.get(name);
	}

	@Transactional
	@Override
	public Customer get(int id) {
		return customerDAO.get(id);
	}

	@Transactional
	@Override
	public void save(Customer customer) {
		customerDAO.save(customer);
	}

	@Transactional
	@Override
	public void remove(int id) {
		customerDAO.remove(id);
	}
	
	@Transactional
	@Override
	public List<Customer> sort(String sortBy) {
		return customerDAO.sort(sortBy);
	}

}
