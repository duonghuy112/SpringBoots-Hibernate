package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class PracticeEmployeeDemo {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Employee.class)
									.buildSessionFactory();

		// Create
		Session session1 = factory.getCurrentSession();
		session1.beginTransaction();
		Employee e = new Employee("Le", "Ngan", "mgm");
		session1.save(e);
		session1.getTransaction().commit();
		
		// Read by Primary Key
		Session session2 = factory.getCurrentSession();
		session2.beginTransaction();
		int employeeId = 1;
		Employee e1 = session2.get(Employee.class, employeeId);
		System.out.println(e1);
		session2.getTransaction().commit();
		
		// Read: query objects to find employees for a given company.
		Session session3 = factory.getCurrentSession();
		session3.beginTransaction();
		List<Employee> list = session3.createQuery("from Employee").getResultList();
		list.forEach(System.out::println);
		session3.getTransaction().commit();
		
		// Delete by Primary Key
		Session session4 = factory.getCurrentSession();
		session4.beginTransaction();
		int eId = 1;
		Employee e2 = session4.get(Employee.class, eId);
		session4.delete(e2);
		session4.getTransaction().commit();
		
		factory.close();
	}
}
