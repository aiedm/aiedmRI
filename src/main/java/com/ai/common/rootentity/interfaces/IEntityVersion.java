package com.ai.common.rootentity.interfaces;

import java.sql.Timestamp;

public interface IEntityVersion {
	long getVersionOperatorId();
	void setVersionOperatorId(long VersionOperatorId);	
	Timestamp getVersionTime();
	void setVersionTime(Timestamp VersionTime);
	String getVersion();
	void setVersion(String version);
}
