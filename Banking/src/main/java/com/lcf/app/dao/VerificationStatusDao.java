package com.lcf.app.dao;

import java.util.List;

import com.lcf.app.beans.VerificationStatus;

public interface VerificationStatusDao {
	
	public abstract boolean createReference(VerificationStatus reference);
	public abstract long getReferenceById(long id);
	public abstract List<VerificationStatus> displayAll();

}
