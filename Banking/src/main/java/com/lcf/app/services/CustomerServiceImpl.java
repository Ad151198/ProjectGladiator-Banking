package com.lcf.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcf.app.beans.CustomerDetails;
import com.lcf.app.dao.CustomerDao;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerDao customerDao;

	@Override
	public int newCustomer(CustomerDetails customer) {
		customerDao.newCustomer(customer);
		return 0;
	}

	@Override
	public CustomerDetails getByCustomerId(long id) {
		CustomerDetails customer = customerDao.getByCustomerId(id);
		return customer;
	}

}
