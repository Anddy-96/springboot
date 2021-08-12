package com.luv2code.springdemo;

public class BaseballCoach implements Coach {
	
	public String getDailyWorkout()
	{
		return "30 mins running";
	}
	
	public String coachMessage()
	{
		return "your basketball coach speaking";
	}
}
