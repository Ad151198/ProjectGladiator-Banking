package com.lcf.app.dao;

import org.springframework.web.bind.annotation.RequestBody;

import com.lcf.app.beans.AccountDetails;

public interface AccountDao {
	
	public abstract AccountDetails searchAccountByAccountNumber(long accountNumber);
	public abstract long insertAccount(AccountDetails accountDetails);

}
