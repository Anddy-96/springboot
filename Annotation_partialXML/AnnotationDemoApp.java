package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {

		//read spring config file
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//get bean from spring container
		
		Coach c1 = context.getBean("tennisCoach",Coach.class);
		
		//call methods on it
		System.out.println(c1.getDailyWorkout());
		
		
		System.out.println(c1.getDailyFortune());
		//close the context
		
		context.close();
	}

}
