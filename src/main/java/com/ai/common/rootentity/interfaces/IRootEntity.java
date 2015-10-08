package com.ai.common.rootentity.interfaces;

import java.sql.Timestamp;

import com.ai.crm.common.basetype.interfaces.ITimePeriod;

public interface IRootEntity {
	long getCreateOperatorId();
	void setCreateOperatorId(long createOperatorId);
	Timestamp getCreateTime();
	void setCreateTime(Timestamp VersionTime);	
	IEntityVersion getVersion();
	void setVersion(IEntityVersion version);
	ITimePeriod getValidPeriod();
	void setValidPeriod(ITimePeriod validPeriod);
	boolean isDeleted();
	void setToDeleted();
	void setToUnDeleted();	
}
