package com.luv2code.springdemo.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	//need to inject the session factory 
	@Autowired 
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Customer> getCustomer() {
		
		//get the current hibernate session 
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create query
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);
		// exceute the query and get result
		List<Customer>  customer = theQuery.getResultList();
		//return the result
		
		return customer;
	}


	@Override
	public void saveCustomer(Customer theCustomer) {
		// TODO Auto-generated method stub
		
		//get the current session 
		Session currentSession = sessionFactory.getCurrentSession();
		
		//save or update the customer 
		currentSession.saveOrUpdate(theCustomer);

		
	}


	@Override
	public Customer getCustomer(int theid) {
		// TODO Auto-generated method stub
		
		//get the current session 
		Session currentSession = sessionFactory.getCurrentSession();
		
		//read the data using the ID
		Customer thecustomer = currentSession.get(Customer.class, theid);
		
		
		
		return thecustomer;
	}


	@Override
	public void deleteCustomer(int theid) {
		
		//get current session 
		Session currentSession = sessionFactory.getCurrentSession();
		
		
		//delete the customer with query
		Query thequery = currentSession.createQuery("delete from Customer where id=:customerId");
		
		thequery.setParameter("customerId", theid);
		
		thequery.executeUpdate();
		
	}


	@Override
	public List<Customer> searchCustomer(String thesearch) {
		//get session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//search in database for the name
		
		Query thequery;
		
		if(thesearch != null && thesearch.trim().length() > 0)
		{
			//searching for name
			thequery = currentSession.createQuery("from Customer where lower(firstName) like :thename or lower(lastName) like :thename",Customer.class);
			thequery.setParameter("thename","%"+ thesearch.toLowerCase()+"%");
		}
		else
		{
			thequery = currentSession.createQuery("from Customer", Customer.class);
		}
		
		List<Customer> custoemrs = thequery.getResultList();
		
		return custoemrs;
	}

}








