package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	
	//inject DAO 
	@Autowired
	private CustomerDAO customerDAO;
	@Override
	@Transactional
	public List<Customer> getCustomer() {
		// TODO Auto-generated method stub
		
		return customerDAO.getCustomer();
	}
	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		// TODO Auto-generated method stub
		
		customerDAO.saveCustomer(theCustomer);
		
	}
	@Override
	@Transactional
	public Customer getCustomer(int theid) {
		// TODO Auto-generated method stub
		return customerDAO.getCustomer(theid);
	}
	@Override
	@Transactional
	public void deleteCustomer(int theid) {
		// TODO Auto-generated method stub
		customerDAO.deleteCustomer(theid);
		
	}
	@Override
	@Transactional
	public List<Customer> searchCustomers(String thesearch) {
		// TODO Auto-generated method stub
		return customerDAO.searchCustomer(thesearch);
	}

}
