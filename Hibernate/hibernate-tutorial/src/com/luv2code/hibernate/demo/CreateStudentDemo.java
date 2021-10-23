package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory sessionFactory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		
		// create session
		Session session = sessionFactory.getCurrentSession();
		Student s1 = new Student("Nguyen", "Hung", "hung@gmail.com");
		// start transaction
		session.beginTransaction();
		
		//save student to transaction
		session.save(s1);
		
		// commit transaction
		session.getTransaction().commit();
		
		System.out.println(s1);
		
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Student s2 = session.get(Student.class, s1.getId());
		session.getTransaction().commit();
		System.out.println("okokok: " + s2);
		// close session
		sessionFactory.close();
		
	}

}
