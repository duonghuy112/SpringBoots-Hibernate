package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		Instructor instructor = new Instructor("Le", "Ngan", "ngan@mail.com");
		InstructorDetail instructorDetail = new InstructorDetail("ngankhung.com", "cooking");
		instructor.setInstructorDetail(instructorDetail);
		
		session.beginTransaction();
		
		System.out.println("Saving instructor: " + instructor);
		session.save(instructor);
		
		session.getTransaction().commit();
		System.out.println("Done");
		
		factory.close();
	}
}
