package com.luv2code.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRESTController {
	
	
	//autowire the customer
	@Autowired
	private CustomerService custoemrService;
	//add GET mapping

	@GetMapping("/customers")
	public List<Customer> getCustomers()
	{
		return custoemrService.getCustomers();
	}
	
	@GetMapping("/customers/{customerID}")
	public Customer getCustomer(@PathVariable int customerID)
	{
		
		
		Customer thecust = custoemrService.getCustomer(customerID);
		
		
		if(thecust == null)
		{
			throw new CustomerNotFoundException("Customer ID is not found : "+customerID);
		}
		
		
		return thecust;
	}
	
	
	//add mapping for POST/CUSTOMER - add new customer
	@PostMapping("/customers")
	public Customer addcustoemr(@RequestBody Customer thecustomer)
	{
		thecustomer.setId(0);
		custoemrService.saveCustomer(thecustomer);
		//setting the ID to 0 - as 0 will make the new custoemr add into the database
		
		
		return thecustomer;
	}
	//adding method for put/update the customer
	@PutMapping("/customers")
	public Customer updatecustoemr(@RequestBody Customer thecustomer)
	{
		
		custoemrService.saveCustomer(thecustomer);
		
		
		
		return thecustomer;
	}
	
	// method for deleting customer using delete rest 
	@DeleteMapping("/customers/{customerID}")
	public String deleteCustoemr(@PathVariable int customerID)
	{
		Customer tempcustomer = custoemrService.getCustomer(customerID);
		
		if(tempcustomer == null)
		{
			throw new CustomerNotFoundException("Customer ID is not found : "+customerID);
		}
		
		
		
		custoemrService.deleteCustomer(customerID);
		
		return "Deleting id :"+customerID;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
