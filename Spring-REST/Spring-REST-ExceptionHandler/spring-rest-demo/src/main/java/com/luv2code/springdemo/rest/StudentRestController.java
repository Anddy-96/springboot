package com.luv2code.springdemo.rest;



import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> thestud;
	
	@PostConstruct
	public void loadData()
	{
		 thestud = new ArrayList<>();
		 
		 thestud.add(new Student("ALEX", "Minnor"));
		 thestud.add(new Student("Beka", "Dash"));
		 thestud.add(new Student("Bob", "Bally"));
		
	}
	

	
	//define endpoitnn for /students and return students 
	
	@GetMapping("/students")
	public List<Student> getStudent()
	{
		return thestud;
	}
	
	//define endpoint for "/students{studentid}" -return student at index
	@GetMapping("/students/{studid}")
	public Student getStudent(@PathVariable int studid)
	{
		//just indexing the list 	
		
		
		//check the student id with the list
		
		if(studid >= thestud.size() || studid < 0)
		{
			throw new StudentNotFoundException("Student ID is not in list");
		}
		return thestud.get(studid);
	}
	
	
	//add an expection handlare

	
}










