package com.luv2code.springdemo;

public class TrackCoach implements Coach {

	
	private FortuneService fortuneservice;
	
	
	
	public TrackCoach() {
		super();
	}

	public TrackCoach(FortuneService thefortuneservice)
	{
		fortuneservice = thefortuneservice;
	}
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "this is track coach";
	}
	
	public String coachMessage()
	{
		return "your track coach speaking";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneservice.getFortune();
	}
	
	//inti method 
	
	public void domyStuff()
	{
		System.out.println("trackcoach: do my stuff method");
	}
	//destroy method
	public void destroyMethod()
	{
		System.out.println("track coach : destroy method calling");
	}
	
	
	
	
	
	
	
	
	
}
