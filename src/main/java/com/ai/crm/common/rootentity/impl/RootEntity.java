package com.ai.crm.common.rootentity.impl;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

import com.ai.crm.common.basetype.interfaces.ITimePeriod;
import com.ai.crm.common.rootentity.interfaces.IEntityVersion;
import com.ai.crm.common.rootentity.interfaces.IRootEntity;
@Component
public class RootEntity implements IRootEntity {
	private IEntityVersion version;
	private long createOperatorId;
	private ITimePeriod validPeriod;
	private boolean isDeleted=false;	
	private Timestamp createTime;	

	@Override
	public IEntityVersion getVersion() {
		return this.version;
	}

	@Override
	public void setVersion(IEntityVersion version) {
		this.version=version;
	}

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
