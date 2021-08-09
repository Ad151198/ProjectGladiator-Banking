package com.lcf.app.beans;

import javax.persistence.*;

@Entity
@Table(name="ACCOUNT_DETAILS")
public class AccountDetails {
	
	@Id
	@Column(name="ACCOUNT_NUMBER")
	private long accountNumber;
	
	@Column(name="ACCOUNT_TYPE")
	private String accountType = "Saving";
	
	@Column(name="AVAILABLE_BALANCE")
	private double availableBalance;
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="IFSC")
	private BranchDetails branchDetail;
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="CUSTOMER_ID")
	private CustomerDetails customerDetail;

}
