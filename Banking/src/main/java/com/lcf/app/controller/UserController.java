package com.lcf.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcf.app.beans.AccountDetails;
import com.lcf.app.beans.AddressDetails;
import com.lcf.app.beans.BranchDetails;
import com.lcf.app.beans.CustomerDetails;
import com.lcf.app.beans.IdentityDocuments;
import com.lcf.app.beans.User;
import com.lcf.app.beans.LoginCredentials;
import com.lcf.app.services.AccountService;
import com.lcf.app.services.AddressService;
import com.lcf.app.services.BranchService;
import com.lcf.app.services.CustomerService;
import com.lcf.app.services.IdentityService;
import com.lcf.app.services.LoginService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/banking/lcf/user-page")
public class UserController {

	@Autowired
	AccountService accountService;

	// http://localhost:8090/banking/lcf/user-page/user-profile/account-details/{id}
	@GetMapping("/user-profile/account-details/{id}")
	public AccountDetails searchAccountByAccountNumber(@PathVariable(value = "id") long accountNumber) {
		AccountDetails account = accountService.searchAccountByAccountNumber(accountNumber);
		
		return account;
	}

	// http://localhost:8090/banking/lcf/user-page/register/account-details
	@PostMapping("/register/account-details")
	public long insertAccount(@RequestBody AccountDetails accountDetails) {

		long accountNumber = accountService.insertAccount(accountDetails);
		
		return accountNumber;

	}

	@Autowired
	private AddressService addressService;

	// http://localhost:8090/banking/lcf/user-page/register/address-details
	@PostMapping("/register/address-details")
	public long insertAddress(@RequestBody AddressDetails address) {
		long id = addressService.insertAddress(address);
		System.out.println(address);
		
		return id;
	}
	
	// http://localhost:8090/banking/lcf/user-page/user-profile/address-details/{id}
		@GetMapping("/user-profile/address-details/{id}")
	public AddressDetails getAddressById(@PathVariable(value="id") long addressId) {
		
		AddressDetails address = addressService.getAddressById(addressId);
		
		return address;
	}

	@Autowired
	BranchService branchService;

	// http://localhost:8090/banking/lcf/user-page/user-profile/branch-details/{ifsc}
	@GetMapping("/user-profile/branch-details/{ifsc}")
	public BranchDetails getBranchByIfsc(@PathVariable(value = "ifsc") String ifsc) {

		BranchDetails branch = branchService.getBranchByIfsc(ifsc);
		
		return branch;

	}

	// http://localhost:8090/banking/lcf/user-page/register/branch-details
	@PostMapping("/register/branch-details")
	public String insertBranch(@RequestBody BranchDetails branchDetails) {

		String ifsc = branchService.insertBranch(branchDetails);
		
		return ifsc;

	}

	@Autowired
	private CustomerService customerService;

	// taking new customer details
	// http://localhost:8090/banking/lcf/user-page/register/personal-details
	@PostMapping("/register/personal-details")
	public long newCustomer(@RequestBody CustomerDetails customer) {
		long customerId = customerService.newCustomer(customer);
		// long addressId =
		// addressController.insertAddress(customer.getResidentialAddressObj());
		// customer.setResidentialAddressId(addressId);
		System.out.println(customer);
		
		return customerId;
	}

	// providing customer details by id
	// http://localhost:8090/banking/lcf/user-page/user-profile/personal-details/10000001
	@GetMapping("/user-profile/personal-details/{id}")
	public CustomerDetails getCustomerById(@PathVariable(value = "id") long id) {
		CustomerDetails customer = customerService.getCustomerById(id);
		
		return customer;
	}

	@Autowired
	private LoginService loginService;

	// taking customerId and password as input
	// http://localhost:8090/banking/lcf/user-page/login
	@PostMapping("/login")
	public int login(@RequestBody LoginCredentials log) {
		long userId = log.getCustomerId();
		String password = log.getLoginPassword();
		int flag = loginService.login(userId, password);
		System.out.println(flag);
		
		return flag;
	}

	public LoginCredentials getLoginCredentialsById(long id) {

		LoginCredentials loginObj = loginService.getLoginCredentialsById(id);
		
		return loginObj;
	}


	// taking new customer details
	// http://localhost:8090/banking/lcf/user-page/register
	@PostMapping("/register")
	public long registration(@RequestBody User register) {
		
		long id1, id2;

		AddressDetails tempResidential = register.getResidentialAddressObj();
		AddressDetails tempPermanent = register.getPermanentAddressObj();

		id1 = insertAddress(register.getResidentialAddressObj());

		if (!(tempResidential.getAddressLine1().equals(tempPermanent.getAddressLine1()))
				|| !(tempResidential.getAddressLine2().equals(tempPermanent.getAddressLine2()))
				|| !(tempResidential.getCity().equals(tempPermanent.getCity()))
				|| !(tempResidential.getLandmark().equals(tempPermanent.getLandmark()))
				|| !(tempResidential.getAddressLine2().equals(tempPermanent.getAddressLine2()))
				|| !(tempResidential.getState().equals(tempPermanent.getState()))
				|| !(tempResidential.getPinCode() == (tempPermanent.getPinCode()))) {

			id2 = insertAddress(register.getPermanentAddressObj());

		}

		else {
			id2 = id1;
		}

		CustomerDetails temp = register.getCustomerDetailsObj();
		temp.setPermanentAddressId(id2);
		temp.setResidentialAddressId(id1);
		long id = newCustomer(temp);
		
		return id;
	}

	// http://localhost:8090/banking/lcf/user-page/register/net-banking
	@PostMapping("/register/net-banking")
	public boolean netBankingRegistration(@RequestBody User register) {

		long userId = searchAccountByAccountNumber(register.getAccountNumber()).getCustomerId();
		String password = register.getLoginCredentialsObj().getLoginPassword();
		int tPin = register.getLoginCredentialsObj().getTransactionPin();
		
		LoginCredentials loginObj = new LoginCredentials();
		loginObj.setCustomerId(userId);
		loginObj.setLoginPassword(password);
		loginObj.setTransactionPin(tPin);

		boolean flag = loginService.netBankingRegistration(loginObj);

		return flag;
	}
	
	@Autowired
	IdentityService identityService;

	// http://localhost:8090/banking/lcf/user-page/register/identity-details
	@PostMapping("/register/identity-details")
	public long insertIdentityDocuments(@RequestBody IdentityDocuments identityDocuments) {
		long customerId = identityService.insertIdentityDocuments(identityDocuments);
		return customerId;
	}

	// http://localhost:8090/banking/lcf/user-page/user-profile/identity-details/{id}
	@GetMapping("/user-profile/identity-details/{id}")
	public IdentityDocuments getIdentityDocumentsById(@PathVariable(value = "id") long customerId) {
		IdentityDocuments identity = identityService.getIdentityDocumentsById(customerId);
		return identity;
	}

}
