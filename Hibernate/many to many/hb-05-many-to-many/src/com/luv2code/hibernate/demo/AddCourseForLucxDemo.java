package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class AddCourseForLucxDemo {

	public static void main(String[] args) {
		
		// create session factory 
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Student.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).buildSessionFactory();
		
		//create a session 
		
		Session session  = factory.getCurrentSession();
		
		
		try {
	
			//start the transaction 
			session.beginTransaction();
			// get lucx from database
			int id = 2;
			 Student tempc = session.get(Student.class,id);
			 
			 System.out.println("lucx student: "+tempc);
			 
			 System.out.println("courses of Lucx: "+tempc.getCourses());
			
			
			//make more courses
			Course cur = new Course("Math course: how to learn this");
			Course curs = new Course("Physics course: how to learn this");
			 
			 
			//add lucx to courses
			cur.addStudent(tempc);
			curs.addStudent(tempc);
			//save the courses
			
			System.out.println("\n saving the courses\n");
				session.save(curs);
				session.save(cur);
				
			//commit transaction 
			session.getTransaction().commit();
			
			
			
			System.out.println("i'm done here");
			
			
		} finally {
			// TODO: handle finally clause
			session.close();
			factory.close();
		}
		
		
		
	}

}
