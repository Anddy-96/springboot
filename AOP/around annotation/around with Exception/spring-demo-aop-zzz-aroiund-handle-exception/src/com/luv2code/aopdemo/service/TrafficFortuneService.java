package com.luv2code.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {
	
	 	public String getFortune()
	 	{
	 		try {
				TimeUnit.SECONDS.sleep(5);
				System.out.println("inside just get fortune");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 		return "Heavy traffic";
	 	}

		public String getFortune(boolean check) {
			
			if(check)
			{
				throw new RuntimeException("Exception from get fortune");
			}
			return getFortune();
		}
	 	
}
