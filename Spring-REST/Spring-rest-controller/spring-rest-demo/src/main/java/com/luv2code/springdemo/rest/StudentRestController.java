package com.luv2code.springdemo.rest;



import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	
	//define endpoitnn for /students and return students 
	
	@GetMapping("/students")
	public List<Student> getStudent()
	{
		 List<Student> thestud = new ArrayList<>();
		 
		 thestud.add(new Student("ALEX", "Minnor"));
		 thestud.add(new Student("Beka", "Dash"));
		 thestud.add(new Student("Bob", "Bally"));
		
		 
		 
		return thestud;
	}
	
}
