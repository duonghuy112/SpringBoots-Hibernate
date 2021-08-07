package com.springdemo.service;

import java.util.List;

import com.springdemo.entity.Customer;

public interface CustomerService {

	List<Customer> getAll();

	List<Customer> get(String name);
	
	Customer get(int id);
	
	void save(Customer customer);
	
	void remove(int id);
}
