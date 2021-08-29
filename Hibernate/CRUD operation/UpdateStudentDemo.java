package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		
		// create session factory 
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		
		//create a session 
		
		Session session  = factory.getCurrentSession();
		
		
		try {
			
			int stdID = 1;

			//reterive student based on ID:
			session =  factory.getCurrentSession();
			session.beginTransaction();
			
			//commit the transaction
			System.out.println("\nGetting student with ID: "+stdID);
			
			Student mystud = session.get(Student.class, stdID);
		    
			System.out.println("updating student ...");
			mystud.setFirstName("zengo");
			//commit transaction
			session.getTransaction().commit();
			 
			// new code for updating the email id of all students 
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//updating email id 
			session.createQuery("update Student set email = 'student@gmail.com'").executeUpdate();
			 
			List<Student> stud =session.createQuery("from Student").getResultList();
			
			session.getTransaction().commit();
	
			for(Student st:stud)
			{
				System.out.println(st);
			}
			
			
			
			System.out.println("done");
			
			
		} finally {
			// TODO: handle finally clause
			
			factory.close();
		}
		
		
		
	}

}
