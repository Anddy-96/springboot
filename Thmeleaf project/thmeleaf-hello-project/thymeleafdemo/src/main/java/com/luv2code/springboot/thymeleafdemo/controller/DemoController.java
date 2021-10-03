package com.luv2code.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
	
	@GetMapping("/")
	public String getHello(Model themodel)
	{
		themodel.addAttribute("thedata", new java.util.Date());
		return "helloworld";
	}

}
