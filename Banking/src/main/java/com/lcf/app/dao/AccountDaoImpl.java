package com.lcf.app.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lcf.app.beans.AccountDetails;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public AccountDetails searchAccountByAccountNumber(long accountNumber) {
		AccountDetails account = em.find(AccountDetails.class, accountNumber);
		return account;
	}

	@Override
	@Transactional
	public long insertAccount(AccountDetails accountDetails) {
		em.merge(accountDetails);
		return accountDetails.getAccountNumber();
	}

}
