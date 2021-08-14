package com.lcf.app.services;

import java.util.List;

import com.lcf.app.beans.VerificationStatus;

public interface VerificationStatusService {
	
	public abstract boolean createReference(VerificationStatus reference);
	public abstract long getReferenceById(long id);
	public abstract List<VerificationStatus> displayAll();
	public abstract boolean getStatusByReferenceId(long referenceId);
}
