package com.springdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

	@Autowired
	private SessionFactory factory;
	
	@Override
	public List<Customer> getAll() {
		return factory.getCurrentSession()
					  .createQuery("from Customer order by lastName", Customer.class)
					  .getResultList();
	}
	
	@Override
	public List<Customer> get(String name) {
		List<Customer> customers = new ArrayList<>();
		if (name != null && name.trim().length() > 0) {
			customers = factory.getCurrentSession()
					.createQuery("from Customer "
							+ "where lower(firstName) like :name or lower(lastName) like :name "
							+ "order by lastName", Customer.class)
					.setParameter("name", "%" + name + "%", StandardBasicTypes.STRING)
					.getResultList();
		} else {
			customers = getAll();
		}
		return customers;
	}

	@Override
	public Customer get(int id) {
		return factory.getCurrentSession()
					  .get(Customer.class, id);
	}

	@Override
	public void save(Customer customer) {
		factory.getCurrentSession().saveOrUpdate(customer);
	}

	@Override
	public void remove(int id) {
		factory.getCurrentSession().delete(get(id));
	}
}
