package com.ai.common.rootentity.domain.model;

import java.sql.Timestamp;

import javax.persistence.Column;

import org.springframework.stereotype.Component;

import com.ai.common.basetype.TimePeriod;
@Component
public class RootEntity{
	@Column
	private EntityVersion version;
	@Column
	private long createOperatorId;
	private TimePeriod validPeriod;
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
	
	
	public TimePeriod getValidPeriod() {
		return this.validPeriod;
	}

	
	public void setValidPeriod(TimePeriod validPeriod) {
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
