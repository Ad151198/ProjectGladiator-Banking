package com.lcf.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcf.app.services.LoginService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/banking/lcf/home-page")
public class LoginController {

	@Autowired
	private LoginService loginService;

	@GetMapping("/get-data/{id}/{pwd}")
	public boolean login(@PathVariable(value = "id") long userId, @PathVariable(value = "pwd") String password) {
		boolean flag = loginService.login(userId, password);
		System.out.println(flag);
		return flag;
	}

}
