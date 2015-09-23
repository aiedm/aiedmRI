package com.ai.crm.common.rootentity.impl;

import java.sql.Timestamp;

import com.ai.crm.common.basetype.interfaces.ITimePeriod;
import com.ai.crm.common.rootentity.interfaces.IEntityVersion;

public class EntityVersion implements IEntityVersion {
	private long createOperatorId;
	private Timestamp versionTime;
	private Timestamp createTime;
	private long versionOperatorId;
	private String version;
	private ITimePeriod validPeriod;
	private boolean isDeleted=false;
	
	

	@Override
	public long getCreateOperatorId() {
		return this.createOperatorId;
	}

	@Override
	public void setCreateOperatorId(long createOperatorId) {
		this.createOperatorId=createOperatorId;
	}

	@Override
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	@Override
	public void setCreateTime(Timestamp createTime) {
		this.createTime=createTime;
	}

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

	@Override
	public ITimePeriod getValidPeriod() {
		return this.validPeriod;
	}

	@Override
	public void setValidPeriod(ITimePeriod validPeriod) {
		this.validPeriod=validPeriod;
	}

	@Override
	public boolean isDeleted() {
		return this.isDeleted;
	}

	@Override
	public void setToDeleted() {
		this.isDeleted=true;
	}

	@Override
	public void setToUnDeleted() {
		this.isDeleted=false;
	}

}
