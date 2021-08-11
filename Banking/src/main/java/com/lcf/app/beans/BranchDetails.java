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
	
	@Column(name="ADDRESS_ID")
	private long branchAddressId;

	public BranchDetails() {
		super();
	}

	public BranchDetails(String ifsc, String branchName, long branchAddressId) {
		super();
		this.ifsc = ifsc;
		this.branchName = branchName;
		this.branchAddressId = branchAddressId;
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

	public long getBranchAddressId() {
		return branchAddressId;
	}

	public void setBranchAddressId(long branchAddressId) {
		this.branchAddressId = branchAddressId;
	}

	@Override
	public String toString() {
		return "BranchDetails \n [ifsc=" + ifsc + ", branchName=" + branchName + ", branchAddressId=" + branchAddressId + "]";
	}
	
}
