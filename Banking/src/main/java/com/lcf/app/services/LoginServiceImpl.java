package com.lcf.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcf.app.beans.LoginCredentials;
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

	@Override
	public LoginCredentials getLoginCredentialsById(long id) {
		LoginCredentials loginObj = loginDao.getLoginCredentialsById(id);
		return loginObj;
	}

	@Override
	public boolean netBankingRegistration(LoginCredentials loginObj) {
		boolean flag = loginDao.netBankingRegistration(loginObj);
		return flag;
	}

}
