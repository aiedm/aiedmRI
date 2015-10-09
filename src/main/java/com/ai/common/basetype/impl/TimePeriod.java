package com.ai.common.basetype.impl;

import java.sql.Timestamp;

import com.ai.common.basetype.interfaces.ITimePeriod;

public class TimePeriod implements ITimePeriod {
	private Timestamp beginTime;
	private Timestamp endTime;

	@Override
	public Timestamp getStartTime() {
		return this.beginTime;
	}

	@Override
	public void setBeginTime(Timestamp beginTime) {
		this.beginTime=beginTime;
	}

	@Override
	public Timestamp getEndTime() {
		return this.endTime;
	}

	@Override
	public void setEndTime(Timestamp endTime) {
		this.endTime=endTime;
	}

}
