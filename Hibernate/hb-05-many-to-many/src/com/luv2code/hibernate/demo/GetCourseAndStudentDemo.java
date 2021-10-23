package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.type.StandardBasicTypes;

import com.luv2code.hibernate.entity.Course;
import com.luv2code.hibernate.entity.Instructor;
import com.luv2code.hibernate.entity.InstructorDetail;
import com.luv2code.hibernate.entity.Review;
import com.luv2code.hibernate.entity.Student;

public class GetCourseAndStudentDemo {
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
		
		Student student = session
						.createQuery("select s from Student s where s.lastName = :lastName", Student.class)
						.setParameter("lastName", "Quyen", StandardBasicTypes.STRING)
						.getSingleResult();
		System.out.println(student);
		student.getCourses().forEach(System.out::println);
		
		Course course = session
						.createQuery("select c from Course c where c.id = :courseId", Course.class)
						.setParameter("courseId", 16, StandardBasicTypes.INTEGER)
						.getSingleResult();
		System.out.println(course);
		System.out.println(course.getStudents());
		
		session.getTransaction().commit();
		session.close();
		factory.close();
	}
}
