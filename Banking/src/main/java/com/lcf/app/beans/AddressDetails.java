package com.lcf.app.beans;

import javax.persistence.*;

@Entity
@Table(name="ADDRESS_DETAILS")
public class AddressDetails {
	@Id
	@Column(name="ADDRESS_ID")
	private int addressId;
	
	@Column(name="ADDRESS_LINE1")
	private String addressLine1;
	
	@Column(name="ADDRESS_LINE2")
	private String addressLine2;
	
	@Column(name="LANDMARK")
	private String landmark;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="STATE")
	private String state;
	
	@Column(name="PINCODE")
	private long pinCode;
	

}
