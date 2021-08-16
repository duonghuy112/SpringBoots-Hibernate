package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Customer> getCustomers() {
		return sessionFactory.getCurrentSession()
					  		 .createQuery("from Customer", Customer.class)
							 .getResultList();
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		sessionFactory.getCurrentSession().saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomer(int theId) {
		return sessionFactory.getCurrentSession().get(Customer.class, theId);
	}

	@Override
	public void deleteCustomer(int theId) {
		sessionFactory.getCurrentSession().delete(getCustomer(theId));
	}

}











