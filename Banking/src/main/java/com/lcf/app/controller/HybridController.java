package com.lcf.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcf.app.beans.AddressDetails;
import com.lcf.app.beans.CustomerDetails;
import com.lcf.app.beans.Hybrid;
import com.lcf.app.services.CustomerService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/banking/lcf/home-page")
public class HybridController {

	@Autowired
	private AddressController addressController;

	@Autowired
	private CustomerController customerController;

	private long id1, id2;

	// taking new customer details
	// http://localhost:8090/banking/lcf/home-page/sample
	@PostMapping("/register")
	public long registration(@RequestBody Hybrid samp) {

		AddressDetails tempResidential = samp.getResidentialAddressObj();
		AddressDetails tempPermanent = samp.getPermanentAddressObj();

		id1 = addressController.insertAddress(samp.getResidentialAddressObj());

		if (!(tempResidential.getAddressLine1().equals(tempPermanent.getAddressLine1()))
				|| !(tempResidential.getAddressLine2().equals(tempPermanent.getAddressLine2()))
				|| !(tempResidential.getCity().equals(tempPermanent.getCity()))
				|| !(tempResidential.getLandmark().equals(tempPermanent.getLandmark()))
				|| !(tempResidential.getAddressLine2().equals(tempPermanent.getAddressLine2()))
				|| !(tempResidential.getState().equals(tempPermanent.getState()))
				|| !(tempResidential.getPinCode() == (tempPermanent.getPinCode()))) {

			id2 = addressController.insertAddress(samp.getPermanentAddressObj());

		}

		else {
			id2 = id1;
		}

		CustomerDetails temp = samp.getCustomerDetailsObj();
		temp.setPermanentAddressId(id2);
		temp.setResidentialAddressId(id1);
		long id = customerController.newCustomer(temp);
		return id;
	}
}
