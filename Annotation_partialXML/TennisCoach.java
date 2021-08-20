package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component

public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("RESTFortuneService")
	private FortuneService fortuneservice;
	public TennisCoach()
	{
		System.out.println("inside tennis coach default constructor");
	}
	
	//init method
	
	public void dostuff()
	{
		System.out.println("this is init method after bean construct");
	}
	
	//destroy method
	
	public void dolaststuff()
	{
		System.out.println("this is called when bean is about to be destroyed");
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
