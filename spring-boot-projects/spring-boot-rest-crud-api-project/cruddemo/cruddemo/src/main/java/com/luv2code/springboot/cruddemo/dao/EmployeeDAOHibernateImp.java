package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImp implements EmployeeDAO {

	
	//define field for Entity manager
	private EntityManager entityManager;
	
	//set up cunstroctor injection
	@Autowired
	public EmployeeDAOHibernateImp(EntityManager theEntityManager)
	{
		entityManager = theEntityManager;
	}
	
	@Override
	
	public List<Employee> findAll() {
	
		
		//get the current hibernate session 
		Session currentSession = entityManager.unwrap(Session.class);
		
		//create a query
		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);
		
		//exceute query and get result
		List<Employee> employee = theQuery.getResultList();
		
		//return the result
		
		
		return employee;
	}

	@Override
	
	public Employee findById(int id) {
		
		//get the current hibernate session 
		Session currentSession = entityManager.unwrap(Session.class);
		
		Employee theemployee = currentSession.get(Employee.class, id);
		
		return theemployee;
	}

	@Override
	public void saveEmployee(Employee theEmpeloyee) {
		
		//get the current hibernate session 
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(theEmpeloyee);
	}

	@Override
	public void deleteEmployeeById(int theid) {
		
		//get the current hibernate session 
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query theQuery = currentSession.createQuery("delete from Employee where id =:employeeID");
		theQuery.setParameter("employeeID", theid);
		
		theQuery.executeUpdate();
		
		
		
		
	}

}
