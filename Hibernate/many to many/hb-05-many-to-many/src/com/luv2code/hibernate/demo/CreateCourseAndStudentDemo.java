package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCourseAndStudentDemo {

	public static void main(String[] args) {
		
		// create session factory 
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Student.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).buildSessionFactory();
		
		//create a session 
		
		Session session  = factory.getCurrentSession();
		
		
		try {
	
			//start the transaction 
			session.beginTransaction();
			// create the course 
			Course tempc = new Course("IP class - The IP class for 11th student");
			
	
			
			//save the course 
			System.out.println("saving the course ");
			session.save(tempc);
			
			// create student 
			Student stud = new Student("javky", "jan", "jacky@hjdfk.com");
			Student stude = new Student("lucx", "dan", "lucx@weertw.com");
			
			
			//add Student 
			tempc.addStudent(stud);
			tempc.addStudent(stude);
			
			
			//save the students
			System.out.println("\n saving the student\n");
			session.save(stude);
			session.save(stud);
			
			
			System.out.println("saved students: "+tempc.getStudents());
			
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
