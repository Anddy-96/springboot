package com.luv2code.springdemopractise;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TravelConfig {
	@Bean
	public TireBrand continental()
	{
		return new Continental();
	}
	
	@Bean
	public Vehicle car()
	{
		return new Car(continental());
	}

}
