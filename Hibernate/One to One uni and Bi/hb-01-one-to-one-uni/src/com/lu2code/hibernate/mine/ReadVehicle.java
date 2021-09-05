package com.lu2code.hibernate.mine;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.VehicleAccessiories;

public class ReadVehicle {

	public static void main(String[] args) {

		
		//create session factory 
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(VehicleAccessiories.class).buildSessionFactory();
		
		
		//create a session 
		
		Session session  = factory.getCurrentSession();
		
		
		try {
			
			// create the Vehicle acc data to be added in table create object with paramterise constructor
			
			VehicleAccessiories veha = new VehicleAccessiories("Tyre", 3000, "this is the tyre for vehicle");
			
			session.beginTransaction();
			
			session.save(veha);
			
			session.getTransaction().commit();
			
			System.out.println("check the data, it is added");
			
			
		} finally {
			
			factory.close();
		}
		
	}

}
