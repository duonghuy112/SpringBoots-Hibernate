package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class BiDirectionalDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		
		Session session1 = factory.getCurrentSession();
		session1.beginTransaction();
		
		int instructorDetailId = 3;
		InstructorDetail instructorDetail = session1.get(InstructorDetail.class, instructorDetailId);
		System.out.println(instructorDetail);
		System.out.println(instructorDetail.getInstructor());
		
		session1.getTransaction().commit();
		System.out.println("Done");
		session1.close();
		
		Session session2 = factory.getCurrentSession();
		session2.beginTransaction();
		
		InstructorDetail instructorDetail2 = session2.get(InstructorDetail.class, instructorDetailId);
		
		// trước khi delete, phải ngắt kết nối giữa InstructorDetail tới Instructor
		instructorDetail2.getInstructor().setInstructorDetail(null);
		
		session2.delete(instructorDetail2);
		
		session2.getTransaction().commit();
		session2.close();
		
		factory.close();
	}
}
