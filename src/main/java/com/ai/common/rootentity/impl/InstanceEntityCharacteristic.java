package com.ai.common.rootentity.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.ai.common.rootentity.interfaces.ICharacteristicInstanceValue;
import com.ai.common.rootentity.interfaces.ICharacteristicSpec;
import com.ai.common.rootentity.interfaces.IEntityVersion;
import com.ai.common.rootentity.interfaces.IInstanceEntity;
import com.ai.common.rootentity.interfaces.IInstanceEntityCharacteristic;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Component
public class InstanceEntityCharacteristic extends RootEntity implements IInstanceEntityCharacteristic {
	@JsonIgnore
	private IInstanceEntity instanceEntity;
	private ICharacteristicSpec characteristic;
	private Set<ICharacteristicInstanceValue> characteristicInstanceValues=new HashSet<ICharacteristicInstanceValue>();
	
	@Override
	@JsonIgnore	
	public IInstanceEntity getOwnerInstance() {
		return this.instanceEntity;
	}

	@Override
	public void setOwnerInstance(IInstanceEntity instanceEntity) {
		this.instanceEntity=instanceEntity;
	}

	@Override
	public ICharacteristicSpec getCharacteristic() {
		return this.characteristic;
	}

	@Override
	public void setCharacteristic(ICharacteristicSpec characteristic) {
		this.characteristic=characteristic;
	}

	@Override
	public Set<ICharacteristicInstanceValue> getCharacteristicInstanceValues() {
		return this.characteristicInstanceValues;
	}

	@Override
	public void addCharacteristicInstanceValue(ICharacteristicInstanceValue characteristicInstanceValue) {
		this.characteristicInstanceValues.add(characteristicInstanceValue);
		if (null==characteristicInstanceValue.getInstanceEntityCharacteristic()){
			characteristicInstanceValue.setInstanceEntityCharacteristic(this);
		}

	}

}
