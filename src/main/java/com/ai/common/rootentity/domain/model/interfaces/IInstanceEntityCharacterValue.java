package com.ai.common.rootentity.domain.model.interfaces;

import com.ai.common.rootentity.domain.model.impl.InstanceEntityCharacterValue;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
@JsonTypeInfo(
	    use = JsonTypeInfo.Id.NAME,
	    include = JsonTypeInfo.As.PROPERTY,
	    property = "type")
@JsonSubTypes({
    @Type(value = InstanceEntityCharacterValue.class, name = "CharacteristicInstanceValue"),
})

public interface IInstanceEntityCharacterValue extends IRootEntity{
	IInstanceEntityCharacter getInstanceEntityCharacteristic();
	void setInstanceEntityCharacteristic(IInstanceEntityCharacter instanceEntityCharacteristic);
	ICharacteristicSpecValue getCharacteristicSpecValue();
	void setCharacteristicValue(ICharacteristicSpecValue characteristicValue);
	long getId();
	void setId(long id);
	String getInputedValue();
	void setInputedValue(String value);
}
