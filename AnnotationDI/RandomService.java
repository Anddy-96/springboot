package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomService implements FortuneService {
	
	//random fortune service from array
	
	String [] data = {"my 1st service normal one","my 2nd service better one","my 3rd service last"};

	Random ra = new Random();
	
	
	@Override
	public String getFortune() {
		
	
		int d= ra.nextInt(data.length);
		
		
		return data[d];
	}

}
