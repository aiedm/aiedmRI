package com.ai.common.rootentity.domain.model.interfaces;

import java.util.Set;

import com.ai.common.rootentity.domain.model.impl.InstanceEntityCharacteristic;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

@JsonTypeInfo(
	    use = JsonTypeInfo.Id.NAME,
	    include = JsonTypeInfo.As.PROPERTY,
	    property = "type")
@JsonSubTypes({
    @Type(value = InstanceEntityCharacteristic.class, name = "InstanceEntityCharacteristic"),
})
public interface IInstanceEntityCharacteristic  extends IRootEntity{
	IInstanceEntity getOwnerInstance();
	void setOwnerInstance(IInstanceEntity instanceEntity);
	ICharacteristicSpec getCharacteristic();
	void setCharacteristic(ICharacteristicSpec characteristic);
	Set<ICharacteristicInstanceValue> getCharacteristicInstanceValues();
	void addCharacteristicInstanceValue(ICharacteristicInstanceValue characteristicInstanceValue);
}
