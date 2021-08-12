package com.lcf.app.dao;

import com.lcf.app.beans.CustomerDetails;
import com.lcf.app.beans.LoginCredentials;

public interface LoginDao {
	
	public abstract boolean login(long userId, String password);
	public abstract LoginCredentials getLoginCredentialsById(long id);
	public abstract boolean netBankingRegistration(LoginCredentials loginObj);

}
