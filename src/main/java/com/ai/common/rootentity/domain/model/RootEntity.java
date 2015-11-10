package com.ai.common.rootentity.domain.model;

import java.sql.Timestamp;

import javax.persistence.Column;

import org.springframework.stereotype.Component;

import com.ai.common.basetype.interfaces.ITimePeriod;
@Component
public class RootEntity{
	@Column
	private EntityVersion version;
	@Column
	private long createOperatorId;
	@Column
	private ITimePeriod validPeriod;
	private boolean isDeleted=false;
	@Column
	private Timestamp createTime;	


	
	public EntityVersion getVersion() {
		return this.version;
	}

	
	public void setVersion(EntityVersion version) {
		this.version=version;
	}

	
	public long getCreateOperatorId() {
		return this.createOperatorId;
	}

	
	public void setCreateOperatorId(long createOperatorId) {
		this.createOperatorId=createOperatorId;
	}

	
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	
	public void setCreateTime(Timestamp createTime) {
		this.createTime=createTime;
	}
	
	
	public ITimePeriod getValidPeriod() {
		return this.validPeriod;
	}

	
	public void setValidPeriod(ITimePeriod validPeriod) {
		this.validPeriod=validPeriod;
	}

	
	public boolean isDeleted() {
		return this.isDeleted;
	}

	
	public void setToDeleted() {
		this.isDeleted=true;
	}

	
	public void setToUnDeleted() {
		this.isDeleted=false;
	}
}
