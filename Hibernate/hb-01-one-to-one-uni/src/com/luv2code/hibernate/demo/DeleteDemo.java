package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		int instructorId = 4;
		Instructor instructor = session.get(Instructor.class, instructorId);
		
		if (instructor != null) {
			System.out.println("Deleting: " + instructor);
			session.delete(instructor);
		}
		
		session.getTransaction().commit();
		System.out.println("Done");
		
		factory.close();
	}
}
