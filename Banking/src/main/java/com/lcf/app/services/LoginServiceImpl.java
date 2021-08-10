package com.lcf.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcf.app.dao.LoginDao;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	LoginDao loginDao;
	
	//calling login from DAO layer
	@Override
	public boolean login(long userId, String password) {
		boolean flag = loginDao.login(userId, password);
		return flag;
	}

}
