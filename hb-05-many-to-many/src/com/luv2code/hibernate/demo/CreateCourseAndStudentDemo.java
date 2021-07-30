package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Course;
import com.luv2code.hibernate.entity.Instructor;
import com.luv2code.hibernate.entity.InstructorDetail;
import com.luv2code.hibernate.entity.Review;
import com.luv2code.hibernate.entity.Student;

public class CreateCourseAndStudentDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Review.class)
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();

		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		Course course1 = new Course("Football is the best");
		Course course2 = new Course("Swim is the worst");
		Course course3 = new Course("Volleyball is better");
		
		
		Student s1 = new Student("Nguyen", "Huy", "huy@mail.com");
		Student s2 = new Student("Le", "Ngan", "ngankhung@mail.com");
		Student s3 = new Student("Phan", "Quyen", "quyenpro@mail.com");
		
		course1.getStudents().add(s1);
		course1.getStudents().add(s3);
		
		course2.getStudents().add(s1);
		
		course3.getStudents().add(s1);
		course3.getStudents().add(s2);
		course3.getStudents().add(s3);
		
		session.save(course1);
		session.save(course2);
		session.save(course3);
		
		session.save(s1);
		session.save(s2);
		session.save(s3);
		
		session.getTransaction().commit();
		session.close();
		factory.close();
	}
}
