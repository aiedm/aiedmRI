package com.ai.crm.common.characteristic.domain.model.interfaces;

import java.util.Set;

import org.springframework.stereotype.Component;
@Component
public interface ICharacteristic {
	Set<ICharacteristicValue> getValues();
	void addValue(ICharacteristicValue value);
	long getId();
	void setId(long id);
	String getName();
	void setName(String name);
	String getCode();
	void setCode(String code);
	
}
