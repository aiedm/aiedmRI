package com.ai.common.rootentity.domain.model.interfaces;

import java.util.Set;

import com.ai.common.rootentity.domain.model.impl.InstanceEntityCharacter;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

@JsonTypeInfo(
	    use = JsonTypeInfo.Id.NAME,
	    include = JsonTypeInfo.As.PROPERTY,
	    property = "type")
@JsonSubTypes({
    @Type(value = InstanceEntityCharacter.class, name = "InstanceEntityCharacter"),
})
public interface IInstanceEntityCharacter  extends IRootEntity{
	int getAction();
	void setAction(int action);
	long getCharacterInstanceId();
	void setCharacterInstanceId(long characterInstanceId);
	IInstanceEntity getOwnerInstance();
	void setOwnerInstance(IInstanceEntity instanceEntity);
	long getCharacteristicSpecId();
	void setCharacteristicSpecId(long characteristic);
	Set<IInstanceEntityCharacterValue> getCharacteristicInstanceValues();
	void addCharacteristicInstanceValue(IInstanceEntityCharacterValue characteristicInstanceValue);
}
