package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class GetInstructorCourseDemo {

	public static void main(String[] args) {
		
		// create session factory 
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
		
		//create a session 
		
		Session session  = factory.getCurrentSession();
		
		
		try {
	
			//start the transaction 
			session.beginTransaction();
			
			//get the instructor from db
			
			int ids = 1;
			
			Instructor inst = session.get(Instructor.class, ids);
			
			System.out.println("Instructor: "+inst);
			
			
			//get courses for insrtuctor
			System.out.println("courses: "+inst.getCourse());


			
			//save the instructor

			//commit transaction 
			session.getTransaction().commit();
			
			
			
			System.out.println("done");
			
			
		} finally {
			// TODO: handle finally clause
			session.close();
			factory.close();
		}
		
		
		
	}

}
