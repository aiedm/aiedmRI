package com.ai.common.basetype;

import java.sql.Timestamp;

import javax.persistence.Embeddable;
@Embeddable
public class TimePeriod {
	private Timestamp beginTime;
	private Timestamp endTime;

	
	public Timestamp getBeginTime() {
		return this.beginTime;
	}

	
	public void setBeginTime(Timestamp beginTime) {
		this.beginTime=beginTime;
	}

	
	public Timestamp getEndTime() {
		return this.endTime;
	}

	
	public void setEndTime(Timestamp endTime) {
		this.endTime=endTime;
	}

}
