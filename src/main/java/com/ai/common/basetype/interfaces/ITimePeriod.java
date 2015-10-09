package com.ai.common.basetype.interfaces;

import java.sql.Timestamp;

public interface ITimePeriod {
	Timestamp getStartTime();
	void setBeginTime(Timestamp beginTime);
	Timestamp getEndTime();
	void setEndTime(Timestamp endTime);	
}
