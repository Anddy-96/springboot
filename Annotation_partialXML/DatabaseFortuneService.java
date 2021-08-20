package com.luv2code.springdemo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DatabaseFortuneService implements FortuneService {

	public String myfile = "D:/Spring/eclipse/spring-demo-annotation/src/fortune.txt";
	public List<String> data;
	Random ram = new Random();
	public DatabaseFortuneService()
	{
		BufferedReader abc;
	
		try
		{
			abc = new BufferedReader(new FileReader(myfile));
			data = new ArrayList<String>();
			String s;
			while((s=abc.readLine())!=null) {
			    data.add(s);
			    //System.out.println(s);
			}
			abc.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		{
			
		}
		
		
		// If you want to convert to a String[]
		//String[] da = data.toArray(new String[]{});
		
	}
	}
	
	@Override
	public String getFortune() {
		int d = ram.nextInt(data.size());
		return data.get(d);
	}

}
