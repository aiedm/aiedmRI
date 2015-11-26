package com.ai.common.rootentity.domain.model;

import java.sql.Timestamp;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;

import com.ai.common.basetype.TimePeriod;
@MappedSuperclass
@Access(AccessType.FIELD)
public abstract class RootEntity{
	@Embedded
	private EntityVersion version;
	@Column
	private long createOperatorId;
	@Embedded
	private TimePeriod validPeriod;
	@Column
	private boolean deleted=false;
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

	
	public boolean getDeleted() {
		return this.deleted;
	}

	
	public void setDeleted(boolean isDeleted) {
		this.deleted=isDeleted;
	}


}
