package com.lcf.app.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.lcf.app.beans.AddressDetails;

@Repository("addressDao")
@EnableTransactionManagement
public class AddressDaoImpl implements AddressDao{
	
	@PersistenceContext
	 private EntityManager em;

	@Override
	@Transactional
	public long insertAddress(AddressDetails address) {
		em.persist(address);
		return address.getAddressId();
	}

}
