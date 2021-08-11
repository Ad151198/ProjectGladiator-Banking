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
import com.lcf.app.beans.BranchDetails;
import com.lcf.app.services.AccountService;
import com.lcf.app.services.BranchService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/banking/lcf/home-page")
public class AccountController {
	
	@Autowired
	AccountService accountService;
	
	@GetMapping("/account-details/{id}")
	public AccountDetails searchAccountByAccountNumber(@PathVariable (value="id") long accountNumber) {
		AccountDetails account = accountService.searchAccountByAccountNumber(accountNumber);
		return account;
	}
	
	//http://localhost:8090/banking/lcf/home-page/register/account-details
	@PostMapping("/register/account-details")
	public long insertAccount(@RequestBody AccountDetails accountDetails) {
		
		long accountNumber = accountService.insertAccount(accountDetails);
		return accountNumber;
		
	}
	
	

}
