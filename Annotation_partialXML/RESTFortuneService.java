package com.luv2code.springdemo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.stereotype.Component;

import java.util.*;

import javax.annotation.PostConstruct;

@Component
public class RESTFortuneService implements FortuneService {
	
	
	String myfile = "D:/Spring/eclipse/spring-demo-annotation/src/fortune.txt";
	BufferedReader read;
	List<String> data;
	
	Random ra = new Random();
	
	@PostConstruct
	public void callingFortune()
	{
		try
		{
			read = new BufferedReader(new FileReader(myfile));
			data = new ArrayList<String>();
			String s;
			while((s = read.readLine())!= null)
			{
				data.add(s);
			}
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public String getFortune() {
		int d = ra.nextInt(data.size());
		
		
		return data.get(d);
		
	}

}
