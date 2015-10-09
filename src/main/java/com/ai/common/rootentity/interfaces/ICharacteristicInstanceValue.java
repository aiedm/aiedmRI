package com.ai.common.rootentity.interfaces;

import com.ai.common.rootentity.impl.CharacteristicInstanceValue;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
@JsonTypeInfo(
	    use = JsonTypeInfo.Id.NAME,
	    include = JsonTypeInfo.As.PROPERTY,
	    property = "type")
@JsonSubTypes({
    @Type(value = CharacteristicInstanceValue.class, name = "CharacteristicInstanceValue"),
})

public interface ICharacteristicInstanceValue extends IRootEntity{
	IInstanceEntityCharacteristic getInstanceEntityCharacteristic();
	void setInstanceEntityCharacteristic(IInstanceEntityCharacteristic instanceEntityCharacteristic);
	ICharacteristicSpecValue getCharacteristicSpecValue();
	void setCharacteristicValue(ICharacteristicSpecValue characteristicValue);
	long getId();
	void setId(long id);
	String getValue();
	void setValue(String value);
}
