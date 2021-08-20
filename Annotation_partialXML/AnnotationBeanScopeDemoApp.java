package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		
		
		//load spring file
		
		ClassPathXmlApplicationContext cont = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//get bean
		
		Coach o1 = cont.getBean("tennisCoach", Coach.class);
		Coach o2 = cont.getBean("tennisCoach", Coach.class);
		
		// check the both object are same 
		
		Boolean check = (o1 == o2);
		
		System.out.println("both aboject are pointing to same: "+check);
		System.out.println("address of object1: "+o1);
		System.out.println("address of object2: "+o2);
		
		//close the context
		cont.close();
		
	}

}
