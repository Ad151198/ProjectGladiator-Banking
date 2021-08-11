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
import com.lcf.app.beans.LoginCredentials;
import com.lcf.app.services.CustomerService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/banking/lcf/home-page")
public class HybridController {

	@Autowired
	private AddressController addressController;

	@Autowired
	private CustomerController customerController;
	
	@Autowired
	private LoginController loginController;
	
	@Autowired 
	private AccountController accountController;

	private long id1, id2;

	// taking new customer details
	// http://localhost:8090/banking/lcf/home-page/register
	@PostMapping("/register")
	public long registration(@RequestBody Hybrid register) {

		AddressDetails tempResidential = register.getResidentialAddressObj();
		AddressDetails tempPermanent = register.getPermanentAddressObj();

		id1 = addressController.insertAddress(register.getResidentialAddressObj());

		if (!(tempResidential.getAddressLine1().equals(tempPermanent.getAddressLine1()))
				|| !(tempResidential.getAddressLine2().equals(tempPermanent.getAddressLine2()))
				|| !(tempResidential.getCity().equals(tempPermanent.getCity()))
				|| !(tempResidential.getLandmark().equals(tempPermanent.getLandmark()))
				|| !(tempResidential.getAddressLine2().equals(tempPermanent.getAddressLine2()))
				|| !(tempResidential.getState().equals(tempPermanent.getState()))
				|| !(tempResidential.getPinCode() == (tempPermanent.getPinCode()))) {

			id2 = addressController.insertAddress(register.getPermanentAddressObj());

		}

		else {
			id2 = id1;
		}

		CustomerDetails temp = register.getCustomerDetailsObj();
		temp.setPermanentAddressId(id2);
		temp.setResidentialAddressId(id1);
		long id = customerController.newCustomer(temp);
		return id;
	}
	
	// http://localhost:8090/banking/lcf/home-page/register/net-banking
	@PostMapping("/register/net-banking")
	public boolean netBankingRegistration(@RequestBody Hybrid register) {
		
		long userId = accountController.searchAccountByAccountNumber(register.getAccountNumber()).getCustomerId();
		String password = register.getLoginCredentialsObj().getLoginPassword();
		int tPin = register.getLoginCredentialsObj().getTransactionPin();
		LoginCredentials loginObj = new LoginCredentials(); //loginController.getLoginCredentialsById(userId);
		loginObj.setCustomerId(userId);
		loginObj.setLoginPassword(password);
		loginObj.setTransactionPin(tPin);
		
		boolean flag = loginController.netBankingRegistration(loginObj);
		
		return flag;
	}
}
