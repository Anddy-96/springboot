package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach thecoach = context.getBean("mycoach",Coach.class);
		System.out.println(thecoach.coachMessage());
		
		System.out.println(thecoach.getDailyFortune());
		
		
		context.close();
		
	}

}
