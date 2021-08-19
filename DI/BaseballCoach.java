package com.luv2code.springdemo;

public class BaseballCoach implements Coach {
	
	private FortuneService fortuneservice;
	
	public BaseballCoach(FortuneService thefortuneservice)
	{
		fortuneservice = thefortuneservice;
	}
	
	public String getDailyWorkout()
	{
		return "30 mins running";
	}
	
	public String coachMessage()
	{
		return "your basketball coach speaking";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneservice.getFortune();
	}
	
	
}
