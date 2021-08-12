package com.lcf.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcf.app.beans.VerificationStatus;
import com.lcf.app.dao.VerificationStatusDao;

@Service
public class VerificationStatusServiceImpl implements VerificationStatusService {
	
	@Autowired
	VerificationStatusDao referenceDao;

	@Override
	public boolean createReference(VerificationStatus reference) {
		boolean flag = referenceDao.createReference(reference);
		return flag;
	}

	@Override
	public long getReferenceById(long id) {
		long customerId = referenceDao.getReferenceById(id);
		return customerId;
	}

	@Override
	public List<VerificationStatus> displayAll() {
		List<VerificationStatus> referenceList = referenceDao.displayAll();
		return referenceList;
	}

}
