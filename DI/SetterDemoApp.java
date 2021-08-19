package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 // load the configration file 
		
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			
			// retrieve bean from spring container
			CricketCoach coach = context.getBean("myCricketCoach",CricketCoach.class);
			
			// call methods
			System.out.println(coach.coachMessage());
			System.out.println(coach.getDailyFortune());
			
			//calling litrels method 
			System.out.println(coach.getemailid());
			System.out.println(coach.getteamname());
		
			//close context
			
			context.close();
	}

}
