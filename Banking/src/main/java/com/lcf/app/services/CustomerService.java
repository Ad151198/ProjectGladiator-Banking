package com.lcf.app.services;

import com.lcf.app.beans.CustomerDetails;

public interface CustomerService {
	
	public abstract int newCustomer(CustomerDetails customer);
	public abstract CustomerDetails getByCustomerId(long id);

}
