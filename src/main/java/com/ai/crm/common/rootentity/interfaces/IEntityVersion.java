package com.ai.crm.common.rootentity.interfaces;

import java.sql.Timestamp;

import com.ai.crm.common.basetype.interfaces.ITimePeriod;

public interface IEntityVersion {
	long getCreateOperatorId();
	void setCreateOperatorId(long createOperatorId);
	Timestamp getCreateTime();
	void setCreateTime(Timestamp VersionTime);
	long getVersionOperatorId();
	void setVersionOperatorId(long VersionOperatorId);	
	Timestamp getVersionTime();
	void setVersionTime(Timestamp VersionTime);
	String getVersion();
	void setVersion(String version);
	ITimePeriod getValidPeriod();
	void setValidPeriod(ITimePeriod validPeriod);
	boolean isDeleted();
	void setToDeleted();
	void setToUnDeleted();
}
