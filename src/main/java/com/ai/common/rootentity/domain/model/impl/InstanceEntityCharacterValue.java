package com.ai.common.rootentity.domain.model.impl;

import org.springframework.stereotype.Component;

import com.ai.common.rootentity.domain.model.interfaces.IInstanceEntityCharacterValue;
import com.ai.common.rootentity.domain.model.interfaces.ICharacteristicSpecValue;
import com.ai.common.rootentity.domain.model.interfaces.IInstanceEntityCharacter;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Component
public class InstanceEntityCharacterValue extends RootEntity implements IInstanceEntityCharacterValue {
	@JsonIgnore
	private IInstanceEntityCharacter instanceEntityCharacteristic;
	private ICharacteristicSpecValue characteristicValue;
	private long id;
	private String value;
	
	public InstanceEntityCharacterValue(){
		
	}
			
	public InstanceEntityCharacterValue(IInstanceEntityCharacter instanceEntityCharacteristic, ICharacteristicSpecValue characteristicValue){
		this.setInstanceEntityCharacteristic(instanceEntityCharacteristic);
		this.setCharacteristicValue(characteristicValue);
	}
	
	@Override
	public IInstanceEntityCharacter getInstanceEntityCharacteristic() {
		return this.instanceEntityCharacteristic;
	}

	@Override
	public void setInstanceEntityCharacteristic(IInstanceEntityCharacter instanceEntityCharacteristic) {
		this.instanceEntityCharacteristic=instanceEntityCharacteristic;
	}

	@Override
	public ICharacteristicSpecValue getCharacteristicSpecValue() {
		return this.characteristicValue;
	}

	@Override
	public void setCharacteristicValue(ICharacteristicSpecValue characteristicValue) {
		this.characteristicValue=characteristicValue;
	}

	@Override
	public long getId() {
		return this.id;
	}

	@Override
	public void setId(long id) {
		this.id=id;
	}

	@Override
	public String getInputedValue() {
		return this.value;
	}

	@Override
	public void setInputedValue(String value) {
		this.value=value;
	}

}
