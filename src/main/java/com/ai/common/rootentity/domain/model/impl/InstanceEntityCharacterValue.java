package com.ai.common.rootentity.domain.model.impl;

import org.springframework.stereotype.Component;

import com.ai.common.rootentity.domain.model.interfaces.IInstanceEntityCharacter;
import com.ai.common.rootentity.domain.model.interfaces.IInstanceEntityCharacterValue;
@Component
public class InstanceEntityCharacterValue extends RootEntity implements IInstanceEntityCharacterValue {
	private IInstanceEntityCharacter instanceEntityCharacteristic;
	private long characterValueInstanceId;
	private long characteristicValueId;
	private long id;
	private String value;
	private int action;
	
	public int getAction() {
		return action;
	}


	public void setAction(int action) {
		this.action = action;
	}	
	public InstanceEntityCharacterValue(){
		
	}
			
	public InstanceEntityCharacterValue(IInstanceEntityCharacter instanceEntityCharacteristic, long characteristicValueId){
		this.setInstanceEntityCharacteristic(instanceEntityCharacteristic);
		this.setCharacteristicValueId(characteristicValueId);
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
	public long getCharacteristicSpecValueId() {
		return this.characteristicValueId;
	}

	@Override
	public void setCharacteristicValueId(long characteristicValueId) {
		this.characteristicValueId=characteristicValueId;
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

	@Override
	public long getCharacterValueInstanceId() {
		return this.characterValueInstanceId;
	}

	@Override
	public void setCharacterValueInstanceId(long characterValueInstanceId) {
		this.characteristicValueId=characterValueInstanceId;
	}

}
