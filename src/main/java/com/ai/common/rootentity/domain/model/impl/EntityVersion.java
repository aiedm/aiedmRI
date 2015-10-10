package com.ai.common.rootentity.domain.model.impl;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

import com.ai.common.rootentity.domain.model.interfaces.IEntityVersion;
@Component
public class EntityVersion implements IEntityVersion {	
	private Timestamp versionTime;
	private long versionOperatorId;
	private String version;

	
	@Override
	public long getVersionOperatorId() {
		return this.versionOperatorId;
	}

	@Override
	public void setVersionOperatorId(long versionOperatorId) {
		this.versionOperatorId=versionOperatorId;
	}

	@Override
	public Timestamp getVersionTime() {
		return this.versionTime;
	}

	@Override
	public void setVersionTime(Timestamp versionTime) {
		this.versionTime=versionTime;
	}

	@Override
	public String getVersion() {
		return this.version;
	}

	@Override
	public void setVersion(String version) {
		this.version=version;
	}

}
