package com.ai.crm.common.characteristic.domain.model.interfaces;

import org.springframework.stereotype.Component;

import com.ai.crm.common.characteristic.domain.model.impl.CharacteristicValue;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
@JsonTypeInfo(
	    use = JsonTypeInfo.Id.NAME,
	    include = JsonTypeInfo.As.PROPERTY,
	    property = "type")
@JsonSubTypes({
    @Type(value = CharacteristicValue.class, name = "CharacteristicValue"),
})
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
