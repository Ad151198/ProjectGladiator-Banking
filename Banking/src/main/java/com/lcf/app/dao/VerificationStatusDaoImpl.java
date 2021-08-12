package com.lcf.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.lcf.app.beans.VerificationStatus;

public class VerificationStatusDaoImpl implements VerificationStatusDao{
	
	@PersistenceContext
	EntityManager em;

	@Override
	@Transactional
	public boolean createReference(VerificationStatus reference) {
		em.persist(reference);
		
		return true;
	}

	@Override
	public long getReferenceById(long id) {
		VerificationStatus reference = em.find(VerificationStatus.class, id);
		
		return reference.getCustomerId();
	}

	@Override
	public List<VerificationStatus> displayAll() {
		List<VerificationStatus> referenceList = em.createQuery("SELECT obj FROM VerificationStatus obj").getResultList();
		
		return referenceList;
	}

}
