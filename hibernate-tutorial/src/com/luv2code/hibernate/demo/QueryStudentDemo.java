package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// create session factory
		SessionFactory sessionFactory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		
		// create session
		Session session = sessionFactory.getCurrentSession();
		
		// start transaction
		session.beginTransaction();
		
		List<Student> list = session.createQuery("from Student").getResultList();
		list.forEach(System.out::println);
		
		list = session.createQuery("from Student s where s.lastName='Huy'").getResultList();
		list.forEach(System.out::println);
		// commit transaction
		session.getTransaction().commit();
		
		// close session
		sessionFactory.close();
		
	}

}
