package com.ai.common.rootentity.domain.model.interfaces;

import java.util.Set;

import com.ai.common.rootentity.domain.model.impl.CharacteristicSpec;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
	    use = JsonTypeInfo.Id.NAME,
	    include = JsonTypeInfo.As.PROPERTY,
	    property = "type")
@JsonSubTypes({
    @Type(value = CharacteristicSpec.class, name = "CharacteristicSpec"),
})

public interface ICharacteristicSpec extends IRootEntity{
	Set<ICharacteristicSpecValue> getValues();
	void addValue(ICharacteristicSpecValue value);
	long getId();
	void setId(long id);
	String getName();
	void setName(String name);
	String getCode();
	void setCode(String code);
	
}
