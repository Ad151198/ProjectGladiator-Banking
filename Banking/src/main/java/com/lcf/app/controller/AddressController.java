package com.lcf.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcf.app.beans.AddressDetails;
import com.lcf.app.services.AddressService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/banking/lcf/home-page")
public class AddressController {

	@Autowired
	private AddressService addressService;

	//http://localhost:8090/banking/lcf/home-page/insert
	@PostMapping("/address-details")
	public long insertAddress(@RequestBody AddressDetails address) {
		long id= addressService.insertAddress(address);
		System.out.println(address);
		return id;
	}

}
