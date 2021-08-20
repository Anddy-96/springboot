package com.luv2code.springdemopractise;

import org.springframework.stereotype.Component;

@Component
public class Car implements Vehicle {

	private TireBrand tibr;
	
	
	
	public Car(TireBrand tyre)
	{
		this.tibr = tyre;
	}
	@Override
	public String run() {
		// TODO Auto-generated method stub
		return "this is car run method running";
	}
	
	public String getTireBrand()
	{
		return tibr.TellYourBrand();
	}

}
