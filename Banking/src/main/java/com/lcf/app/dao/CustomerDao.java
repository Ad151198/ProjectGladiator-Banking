package com.lcf.app.dao;

import org.springframework.web.bind.annotation.PathVariable;

import com.lcf.app.beans.CustomerDetails;

public interface CustomerDao {
	
	public abstract int newCustomer(CustomerDetails customer);
	public abstract CustomerDetails getByCustomerId(long id);

}
