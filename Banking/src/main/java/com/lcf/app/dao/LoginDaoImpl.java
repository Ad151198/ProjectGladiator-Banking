package com.lcf.app.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.lcf.app.beans.LoginCredentials;

@Repository("loginDao")
@EnableTransactionManagement
public class LoginDaoImpl implements LoginDao{

	@PersistenceContext
	EntityManager em;
	
	//validating the customerId and password
	@Override
	@Transactional
	public boolean login(long userId, String password) {
		LoginCredentials log = em.find(LoginCredentials.class, userId);
		
		if(log == null) {
			System.out.println("User ID does not exists");
			return false;
		}
		else if(log.getLoginPassword().equals(password)){
			System.out.println("Login successful");
			return true;
			
		}
		else {
			System.out.println("User Id and Password does not match");
			System.out.println(log.getLoginPassword() + password);
			return false;
		}
	}

	@Override
	@Transactional
	public LoginCredentials getLoginCredentialsById(long id) {
		LoginCredentials loginObj = em.find(LoginCredentials.class, id);
		return loginObj;
	}

	@Override
	@Transactional
	public boolean netBankingRegistration(LoginCredentials loginObj) {
		em.persist(loginObj);
		return true;
	}
}
