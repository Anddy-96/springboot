package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

	@RequestMapping("/showForm")
	public String showForm(Model mod)
	{
		
		// create new student object
		Student stud = new Student();
		
		//add object student to model
		mod.addAttribute("student",stud);
		
		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String pForm(@ModelAttribute("student") Student thestud)
	{
		
		//log the input data
		System.out.println("Student name is: "+thestud.getFirstname()+" "+thestud.getLastname());
		
		return "student-confirmation";
	}
	
	
	
}
