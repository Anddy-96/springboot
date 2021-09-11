package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	//inject customer service
	@Autowired
	private CustomerService customerService;
	
	
	
	@GetMapping("/list")
	public String listCustomer(Model themod)
	{
		// GET the customer from service - which is calling DAO
		List<Customer> theCustomer = customerService.getCustomer();
		
		//ADD the custoemr to model
		themod.addAttribute("customers",theCustomer);
		
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model themodel)
	{
		Customer thecust = new Customer();
		themodel.addAttribute("customer",thecust);
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer)
	{
		//save the customer using our service
		customerService.saveCustomer(theCustomer);
		
		return "redirect:/customer/list";
	}
	
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerID") int theid, Model themodel)
	{
		//get the customer from the service
		Customer thecustomer = customerService.getCustomer(theid);
		
		//set the customer as a model attribute to pre-population the form
		themodel.addAttribute("customer",thecustomer);
		
		//send over to our form
		
		
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerID") int theid)
	{
		//delete the customer
		customerService.deleteCustomer(theid);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/search")
	public String searchCustomer(@RequestParam("theSearchName") String thesearch, Model themodel)
	{
		
		List<Customer> thecustomer = customerService.searchCustomers(thesearch);
		
		themodel.addAttribute("customers",thecustomer);
		return "list-customers";
	}

}






