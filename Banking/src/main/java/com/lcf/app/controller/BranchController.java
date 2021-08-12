package com.lcf.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcf.app.beans.BranchDetails;
import com.lcf.app.services.BranchService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/banking/lcf/home-page")
public class BranchController {
	
	@Autowired
	BranchService branchService;
	
	//http://localhost:8090/banking/lcf/home-page/register/branch-details/'1234'
	@GetMapping("/branch-details/{ifsc}")
	public BranchDetails getBranchByIfsc(@PathVariable(value= "ifsc") String ifsc) {
		
		BranchDetails branch = branchService.getBranchByIfsc(ifsc);
		return branch;
		
	}
	
	@PostMapping("/register/branch-details")
	public String insertBranch(@RequestBody BranchDetails branchDetails) {
		
		String ifsc = branchService.insertBranch(branchDetails);
		return ifsc;
		
	}

}
