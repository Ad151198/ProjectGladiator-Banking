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

}
