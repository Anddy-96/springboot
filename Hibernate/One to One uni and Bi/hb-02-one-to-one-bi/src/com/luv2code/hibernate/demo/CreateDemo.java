package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		
		
		// create session factory 
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		
		
		//create a session 
		
		Session session  = factory.getCurrentSession();
		
		
		try {
			
			
			// create the object
	/*		Instructor inttemp = new Instructor("dab", "max", "dabnmax@gnmail.con");
			
			InstructorDetail insdtemp = new InstructorDetail("pathofyoutubechannel", "fixing");
			
	*/
			
			Instructor inttemp = new Instructor("naby", "lecu", "nabyy@gnmail.con");
			
			InstructorDetail insdtemp = new InstructorDetail("youtube", "texting");
			
			//associate the object
			inttemp.setInstructorDetail(insdtemp);
			
			//start the transaction 
			session.beginTransaction();
			
			//save the instructor
		
			//this save will also save the insdtemp object also as it is cascaded by selecting all
			session.save(inttemp);
			//commit transaction 
			session.getTransaction().commit();
			
			System.out.println("saving object: "+insdtemp);
			
			System.out.println("done");
			
			
		} finally {
			// TODO: handle finally clause
			
			factory.close();
		}
		
		
		
	}

}
