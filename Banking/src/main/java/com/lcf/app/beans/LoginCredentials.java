package com.lcf.app.beans;

import javax.persistence.*;

@Entity
@Table(name="LOGIN_CREDENTIALS")
public class LoginCredentials {
	
	@Id
	@Column(name="CUSTOMER_ID")
	private long customerId;
	
	@Column(name="LOGIN_PASSWORD")
	private String loginPassword;
	
	@Column(name="TRANSACTION_PIN")
	private int transactionPin;
	
	
//	this.customerId = CustomerDetails.customerId;

}
