package com.luv2code.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		
		
		try {
			
			//create the object mapper
			ObjectMapper mapper = new ObjectMapper();
			
			//read the json file and map/convert it to Java POJO
			Student thestud = mapper.readValue(new File("data/sample-full.json"), Student.class);
			
			//Print the values
			System.out.println("First Name :"+thestud.getFirstName());

			System.out.println("First Name :"+thestud.getLastName());
			
			//GET ADDRESS
			Address theadd = thestud.getAddress();
			
			System.out.println("Street is :"+theadd.getStreet());
			System.out.println("Street is :"+theadd.getCity());
			
			for(String templ : thestud.getLanguages())
			{
				System.out.println(templ);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
