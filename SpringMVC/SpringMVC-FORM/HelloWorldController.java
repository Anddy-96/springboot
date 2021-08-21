package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

	
	// need a controller to show the form
	@RequestMapping("/showForm")
	public String showForm()
	{
		return "helloworld-form";
	}
	
	//need a controller method to process the form
	@RequestMapping("/processForm")
	public String processForm()
	{
		return "helloworld";
	}
	
	
	//need a new controller for new method
	//add data to the model
	@RequestMapping("/processFormVerTwp")
	public String bigGame(HttpServletRequest req, Model model)
	{
		//read the request parameter from the HTML form
		
		String thename = req.getParameter("studentName");
		
		//convert it to upper case
		thename = thename.toUpperCase();
		
		//create addition message
		String result = "yup! "+thename;
		
		// add msg to model
		model.addAttribute("msg",result);
		
		
		
		
		
		
		return "helloworld";
	}
	
	
}
