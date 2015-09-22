package com.ai.crm.common.characteristic.domain.model.interfaces;

import java.util.Set;

import org.springframework.stereotype.Component;

import com.ai.crm.common.characteristic.domain.model.impl.Characteristic;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
	    use = JsonTypeInfo.Id.NAME,
	    include = JsonTypeInfo.As.PROPERTY,
	    property = "type")
@JsonSubTypes({
    @Type(value = Characteristic.class, name = "Characteristic"),
})
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
