package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCourseDemo {

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
			
			
			//create some course 
			
			Course ct = new Course("Air Duct know");
			
			Course ct2 = new Course("Power know");
			
			//add course to instrucctor
			inst.add(ct);
			inst.add(ct2);
			
			
			//save the instructor
			session.save(ct);
			session.save(ct2);
			
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
