package com.lcf.app.dao;

import com.lcf.app.beans.AddressDetails;

public interface AddressDao {
	
	public abstract int insertAddress(AddressDetails address);
	public abstract AddressDetails getAddressById(int addressId);

}
