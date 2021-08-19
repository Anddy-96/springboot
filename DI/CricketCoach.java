package com.luv2code.springdemo;

public class CricketCoach implements Coach {

	private FortuneService fortuneservice;
	private String emailid;
	private String teamname;
	
	public CricketCoach()
	{
		System.out.println("inside cricket constructor: no-arg constructor");
	}
	
	public void setfortuneservice(FortuneService fortuneservice)
	{
		System.out.println("inside setter method");
		this.fortuneservice = fortuneservice;
	}
	
	public void setemailid(String emailid)
	{
		System.out.println("seting the mail id");
		this.emailid = emailid;
	}
	
	public void setteamname(String team)
	{
		System.out.println("seting team");
		this.teamname = team;
	}
	
	public String getemailid()
	{
		return emailid;
	}
	public String getteamname()
	{
		return teamname;
	}
	
	
	
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "cricket coach: bat welll";
	}

	@Override
	public String coachMessage() {
		// TODO Auto-generated method stub
		return "Cricket coach is messaging";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneservice.getFortune();
	}

}
