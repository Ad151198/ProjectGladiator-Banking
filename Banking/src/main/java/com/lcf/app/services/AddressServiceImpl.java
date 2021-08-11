package com.lcf.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcf.app.beans.AddressDetails;
import com.lcf.app.dao.AddressDao;

@Service
public class AddressServiceImpl implements AddressService{

	@Autowired
	private AddressDao addressDao;
	
	@Override
	public String insertAddress(AddressDetails address) {
		
		String string= addressDao.insertAddress(address);
		return string;
	}

}
