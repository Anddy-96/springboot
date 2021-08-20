package com.luv2code.springdemopractise;

import org.springframework.stereotype.Component;

@Component
public class Bike implements Vehicle {

	@Override
	public String run() {
		
		return "bike is running fast";
	}

}
