package com.lcf.app.beans;

import javax.persistence.*;

@Entity
@Table(name="IDENTITY_DOCUMENTS")
public class IdentityDocuments {
	
	@Id
	@Column(name="CUSTOMER_ID")
	private long customerId;
	
	@Column(name="AADHAR_NUMBER")
	private long aadharNumber;
	
	@Column(name="PAN")
	private String pan;
<<<<<<< HEAD
	private long customerId;
=======
	
>>>>>>> branch 'main' of https://github.com/Ad151198/ProjectGladiator-Banking.git

}
