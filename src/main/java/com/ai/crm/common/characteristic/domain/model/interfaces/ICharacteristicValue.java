package com.ai.crm.common.characteristic.domain.model.interfaces;

import org.springframework.stereotype.Component;

@Component
public interface ICharacteristicValue {
	ICharacteristic getCharacteristic();
	void setCharacteristic(ICharacteristic characteristic);
	long getId();
	void setId(long id);
	String getValue();
	void setValue(String value);
	String getDisplayValue();
	void setDisplayValue(String displayValue);
	boolean isDefault();
	void setDefault(boolean isDefault);
	long getValueFrom();
	void setValueFrom(long valueFrom);
	long getValueTo();
	void setValueTo(long valueTo);
	long getRangeInterval();
	void setRangeInterval(long rangeInterval);
}
