package com.ai.common.basetype;

import java.sql.Timestamp;

public class TimePeriod {
	private Timestamp beginTime;
	private Timestamp endTime;

	
	public Timestamp getStartTime() {
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
