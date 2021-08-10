package com.lcf.app.beans;

import javax.persistence.*;

@Entity
@Table(name="BRANCH_DETAILS")
public class BranchDetails {
	
	@Id
	@Column(name="IFSC")
	private String ifsc;
	
	@Column(name="BRANCH_NAME")
	private String branchName;
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="ADDRESS_ID")
	private AddressDetails branchAddress;

	public BranchDetails() {
		super();
	}

	public BranchDetails(String ifsc, String branchName, AddressDetails branchAddress) {
		super();
		this.ifsc = ifsc;
		this.branchName = branchName;
		this.branchAddress = branchAddress;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public AddressDetails getBranchAddress() {
		return branchAddress;
	}

	public void setBranchAddress(AddressDetails branchAddress) {
		this.branchAddress = branchAddress;
	}

	@Override
	public String toString() {
		return "BranchDetails \n [ifsc=" + ifsc + ", branchName=" + branchName + ", branchAddress=" + branchAddress + "]";
	}
	
}
