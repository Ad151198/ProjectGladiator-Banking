package com.lcf.app.beans;

public class Hybrid {
	
	private CustomerDetails customerDetailsObj;
	private AddressDetails permanentAddressObj;
	private AddressDetails residentialAddressObj;
	
	public Hybrid() {
		super();
	}
	
	public Hybrid(CustomerDetails customerDetailsObj, AddressDetails permanentAddressObj,
			AddressDetails residentialAddressObj) {
		super();
		this.customerDetailsObj = customerDetailsObj;
		this.permanentAddressObj = permanentAddressObj;
		this.residentialAddressObj = residentialAddressObj;
	}
	
	public CustomerDetails getCustomerDetailsObj() {
		return customerDetailsObj;
	}
	public void setCustomerDetailsObj(CustomerDetails customerDetailsObj) {
		this.customerDetailsObj = customerDetailsObj;
	}
	public AddressDetails getPermanentAddressObj() {
		return permanentAddressObj;
	}
	public void setPermanentAddressObj(AddressDetails permanentAddressObj) {
		this.permanentAddressObj = permanentAddressObj;
	}
	public AddressDetails getResidentialAddressObj() {
		return residentialAddressObj;
	}
	public void setResidentialAddressObj(AddressDetails residentialAddressObj) {
		this.residentialAddressObj = residentialAddressObj;
	}
	
	@Override
	public String toString() {
		return "Hybrid [customerDetailsObj=" + customerDetailsObj + ", permanentAddressObj=" + permanentAddressObj
				+ ", residentialAddressObj=" + residentialAddressObj + "]";
	}
	
}
