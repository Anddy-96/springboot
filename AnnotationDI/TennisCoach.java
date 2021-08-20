package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("databaseFortuneService")
	private FortuneService fortuneservice;
	public TennisCoach()
	{
		System.out.println("inside tennis coach default constructor");
	}
	//used for constructor injection
/*	
	@Autowired
	public TennisCoach(FortuneService fortuneservice)
	{
		this.fortuneservice = fortuneservice;
		System.out.println("inside tennis coach parameterized constructor");
	}
*/	
	// you can setter methoad and call it with autowired - it will called as setter injection 
	
	
	
	//methoad can be injected just remember to use the parameterzied methoad and should point to some interface or class which has component written on it
	//when we use field injection even this is not required.
/*	
	@Autowired
	public void myMethod(FortuneService fort)
	{
		this.fortuneservice = fort;
		System.out.println("inside tennis coach --mymethod-- method: ");
	}
*/	
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "practice hitting hard";
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneservice.getFortune();
	}

}
