package com.lcf.app.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.lcf.app.beans.CustomerDetails;

@Repository("customerDao")
@EnableTransactionManagement
public class CustomerDaoImpl implements CustomerDao {

	@PersistenceContext
	EntityManager em;
	
	//adding new customer details via customerdetails class
	@Override
	@Transactional
	public int newCustomer(CustomerDetails customer) {
		System.out.println("dao");
		em.persist(customer);
		return 0;
	}

	@Override
	@Transactional
	public CustomerDetails getByCustomerId(long id) {
		CustomerDetails customer = em.find(CustomerDetails.class, id);
		return customer;
	}

}
