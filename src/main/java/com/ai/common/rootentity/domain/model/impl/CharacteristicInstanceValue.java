package com.ai.common.rootentity.domain.model.impl;

import org.springframework.stereotype.Component;

import com.ai.common.rootentity.domain.model.interfaces.ICharacteristicInstanceValue;
import com.ai.common.rootentity.domain.model.interfaces.ICharacteristicSpecValue;
import com.ai.common.rootentity.domain.model.interfaces.IInstanceEntityCharacteristic;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Component
public class CharacteristicInstanceValue extends RootEntity implements ICharacteristicInstanceValue {
	@JsonIgnore
	private IInstanceEntityCharacteristic instanceEntityCharacteristic;
	private ICharacteristicSpecValue characteristicValue;
	private long id;
	private String value;
	
	public CharacteristicInstanceValue(){
		
	}
			
	public CharacteristicInstanceValue(IInstanceEntityCharacteristic instanceEntityCharacteristic, ICharacteristicSpecValue characteristicValue){
		this.setInstanceEntityCharacteristic(instanceEntityCharacteristic);
		this.setCharacteristicValue(characteristicValue);
	}
	
	@Override
	public IInstanceEntityCharacteristic getInstanceEntityCharacteristic() {
		return this.instanceEntityCharacteristic;
	}

	@Override
	public void setInstanceEntityCharacteristic(IInstanceEntityCharacteristic instanceEntityCharacteristic) {
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
	public String getValue() {
		return this.value;
	}

	@Override
	public void setValue(String value) {
		this.value=value;
	}

}
