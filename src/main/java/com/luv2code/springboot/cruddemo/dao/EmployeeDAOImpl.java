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
@Transactional
public class EmployeeDAOImpl implements EmployeeDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Employee> findAll() {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Employee> theQuery = 
				currentSession.createQuery("from Employee", Employee.class);
		
		return theQuery.getResultList();
	}

}










