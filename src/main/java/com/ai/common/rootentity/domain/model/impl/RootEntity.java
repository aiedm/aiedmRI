package com.ai.common.rootentity.domain.model.impl;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

import com.ai.common.basetype.interfaces.ITimePeriod;
import com.ai.common.rootentity.domain.model.interfaces.IEntityVersion;
import com.ai.common.rootentity.domain.model.interfaces.IRootEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Component
public class RootEntity implements IRootEntity {
	@JsonIgnore
	private IEntityVersion version;
	@JsonIgnore
	private long createOperatorId;
	@JsonIgnore
	private ITimePeriod validPeriod;
	@JsonIgnore
	private boolean isDeleted=false;
	@JsonIgnore
	private Timestamp createTime;	
	private long id;

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

	@Override
	public long getId() {
		return this.id;
	}

	@Override
	public void setId(long id) {
		this.id=id;
	}	

}
