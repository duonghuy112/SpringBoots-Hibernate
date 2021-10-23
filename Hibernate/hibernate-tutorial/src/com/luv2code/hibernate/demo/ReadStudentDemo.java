package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

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
		
		//save student to transaction
		session.save(new Student("Nguyen", "Huy", "huy@gmail.com"));
		
		// commit transaction
		session.getTransaction().commit();
		
		// close session
		sessionFactory.close();
		
	}

}
