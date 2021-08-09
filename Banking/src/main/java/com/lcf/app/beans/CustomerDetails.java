package com.lcf.app.beans;

import javax.persistence.*;

@Entity
@Table(name="CUSTOMER_DETAILS")
public class CustomerDetails {
	
	@Id
	@Column(name="CUSTOMER_ID")
	private long customerId;
	
	@Column(name="CUSTOMER_NAME")
	private String customerName;
	
	@Column(name="CONTACT_NUMBER")
	private long contactNumber;
	
	@Column(name="DOB")
	private String dob;
	
	@Column(name="GENDER")
	private String gender;
	
	@Column(name="OCCUPATION")
	private String occupation;
	
	@Column(name="ANNUAL_INCOME")
	private double annualIncome;
	
	@Column(name="EMAIL_ID")
	private String emailId;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ADDRESS_ID")
	private AddressDetails residentialAddress;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ADDRESS_ID")
	private AddressDetails permanentAddress;
	
}
