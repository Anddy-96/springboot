package com.luv2code.springdemo;

import java.util.Random;

public class HappyFortuneService implements FortuneService {

	public String getFortune() {
		// TODO Auto-generated method stub
		
		String arr[] = {"1st fortune","2nd fortune","3rd fortune"};
		
		Random a = new Random();
		int ret = a.nextInt(arr.length);
		
		return arr[ret];
	}

}
