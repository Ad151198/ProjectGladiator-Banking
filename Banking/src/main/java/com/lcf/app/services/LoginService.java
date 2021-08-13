package com.lcf.app.services;

import com.lcf.app.beans.LoginCredentials;

public interface LoginService {
	
	public abstract int login(long userId, String password);
	public abstract LoginCredentials getLoginCredentialsById(long id);
	public abstract boolean netBankingRegistration(LoginCredentials loginObj);

}
