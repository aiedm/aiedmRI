package com.ai.common.rootentity.domain.model.interfaces;

import com.ai.common.rootentity.domain.model.impl.CharacteristicSpecValue;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
@JsonTypeInfo(
	    use = JsonTypeInfo.Id.NAME,
	    include = JsonTypeInfo.As.PROPERTY,
	    property = "type")
@JsonSubTypes({
    @Type(value = CharacteristicSpecValue.class, name = "CharacteristicSpecValue"),
})
public interface ICharacteristicSpecValue  extends IRootEntity{
	ICharacteristicSpec getCharacteristic();
	void setCharacteristic(ICharacteristicSpec characteristic);
	long getId();
	void setId(long id);
	String getCode();
	void setCode(String code);
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
