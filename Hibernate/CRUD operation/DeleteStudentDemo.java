package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		
		// create session factory 
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		
		//create a session 
		
		Session session  = factory.getCurrentSession();
		
		
		try {
			
			int stdID = 6;

			//reterive student based on ID:
			session =  factory.getCurrentSession();
			session.beginTransaction();
			
			//commit the transaction
			System.out.println("\nDeleting student with "+stdID);
			
			Student mystud = session.get(Student.class, stdID);

			
			
			//delete the student ID
			session.delete(mystud);
			
			//deleting using query
			session.createQuery("delete Student where id = 5").executeUpdate();
			
			//commit transaction
			session.getTransaction().commit();
			 
			
	
			
			System.out.println("done");
			
			
		} finally {
			// TODO: handle finally clause
			
			factory.close();
		}
		
		
		
	}

}
