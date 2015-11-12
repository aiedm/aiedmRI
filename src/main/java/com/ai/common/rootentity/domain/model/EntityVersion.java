package com.ai.common.rootentity.domain.model;

import java.sql.Timestamp;

import javax.persistence.Embeddable;

@Embeddable
public class EntityVersion{	
	private Timestamp versionTime;
	private long versionOperatorId;
	private String version;

	
	
	public long getVersionOperatorId() {
		return this.versionOperatorId;
	}

	
	public void setVersionOperatorId(long versionOperatorId) {
		this.versionOperatorId=versionOperatorId;
	}

	
	public Timestamp getVersionTime() {
		return this.versionTime;
	}

	
	public void setVersionTime(Timestamp versionTime) {
		this.versionTime=versionTime;
	}

	
	public String getVersion() {
		return this.version;
	}

	
	public void setVersion(String version) {
		this.version=version;
	}

}
