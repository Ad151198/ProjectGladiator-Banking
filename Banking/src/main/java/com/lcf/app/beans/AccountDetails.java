package com.lcf.app.beans;

import javax.persistence.*;

@Entity
@Table(name="ACCOUNT_DETAILS")
public class AccountDetails {
	
	@Id
	@Column(name="ACCOUNT_NUMBER")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HB_ACC_SEQ")
	@SequenceGenerator(name = "HB_ACC_SEQ", sequenceName = "Account_Number_Sequence", allocationSize = 1)
	private long accountNumber;
	
	@Column(name="ACCOUNT_TYPE")
	private String accountType = "Saving";
	
	@Column(name="AVAILABLE_BALANCE")
	private long availableBalance;
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="IFSC")
	private BranchDetails branchDetail;
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="CUSTOMER_ID")
	private CustomerDetails customerDetail;

	public AccountDetails() {
		super();
	}

	public AccountDetails(long accountNumber, String accountType, long availableBalance, BranchDetails branchDetail,
			CustomerDetails customerDetail) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.availableBalance = availableBalance;
		this.branchDetail = branchDetail;
		this.customerDetail = customerDetail;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(long availableBalance) {
		this.availableBalance = availableBalance;
	}

	public BranchDetails getBranchDetail() {
		return branchDetail;
	}

	public void setBranchDetail(BranchDetails branchDetail) {
		this.branchDetail = branchDetail;
	}

	public CustomerDetails getCustomerDetail() {
		return customerDetail;
	}

	public void setCustomerDetail(CustomerDetails customerDetail) {
		this.customerDetail = customerDetail;
	}

	@Override
	public String toString() {
		return "AccountDetails \n [accountNumber=" + accountNumber + ", accountType=" + accountType + ", availableBalance="
				+ availableBalance + ", branchDetail=" + branchDetail + ", customerDetail=" + customerDetail + "]";
	}

}
