package com.lcf.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcf.app.beans.CustomerDetails;
import com.lcf.app.services.CustomerService;
import com.lcf.app.services.CustomerServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/banking/lcf/home-page")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private AddressController addressController;
	
	// taking new customer details
	// http://localhost:8090/banking/lcf/home-page/apply
	@PostMapping("/apply")
	public long newCustomer(@RequestBody CustomerDetails customer) {
		long customerId= customerService.newCustomer(customer);
		//long addressId = addressController.insertAddress(customer.getResidentialAddressObj());
		//customer.setResidentialAddressId(addressId);
		System.out.println(customer);
		return customerId;
	}

	// providing customer details by id
	// http://localhost:8090/banking/lcf/home-page/user-profile/10000001
	@GetMapping("/user-profile/{id}")
	public CustomerDetails getCustomerById(@PathVariable(value = "id") long id) {
		CustomerDetails customer = customerService.getCustomerById(id);
		return customer;
	}

}
