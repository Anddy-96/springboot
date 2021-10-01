package com.luv2code.springboot.demo.myspringcoolapp.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	
	//INJECT PROPERTIES FROM spplication properties file
	@Value("${coach.name}")
	private String coachName;
	
	@Value("${team.name}")
	private String teamName;
	
	//expose the endpoint which will display the above info
	
	@GetMapping("/teaminfo")
	public String getTemaInfo()
	{
		return "Coach name :"+coachName+", Team Name :"+teamName;
	}
	
	
	@GetMapping("/")
	public String sayHello()
	{
		return "Hello Worlds, the time on server is :"+LocalDateTime.now();
	}
	
	@GetMapping("/workout")
	public String getWorkout()
	{
		return "hard run";
	}
	
}
