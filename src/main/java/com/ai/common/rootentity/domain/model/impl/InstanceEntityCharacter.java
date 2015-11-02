package com.ai.common.rootentity.domain.model.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.ai.common.rootentity.domain.model.interfaces.IInstanceEntityCharacterValue;
import com.ai.common.rootentity.domain.model.interfaces.ICharacteristicSpec;
import com.ai.common.rootentity.domain.model.interfaces.IEntityVersion;
import com.ai.common.rootentity.domain.model.interfaces.IInstanceEntity;
import com.ai.common.rootentity.domain.model.interfaces.IInstanceEntityCharacter;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Component
public class InstanceEntityCharacter extends RootEntity implements IInstanceEntityCharacter {
	@JsonIgnore
	private IInstanceEntity instanceEntity;
	private ICharacteristicSpec characteristic;
	private Set<IInstanceEntityCharacterValue> characteristicInstanceValues=new HashSet<IInstanceEntityCharacterValue>();
	
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
	public Set<IInstanceEntityCharacterValue> getCharacteristicInstanceValues() {
		return this.characteristicInstanceValues;
	}

	@Override
	public void addCharacteristicInstanceValue(IInstanceEntityCharacterValue characteristicInstanceValue) {
		this.characteristicInstanceValues.add(characteristicInstanceValue);
		if (null==characteristicInstanceValue.getInstanceEntityCharacteristic()){
			characteristicInstanceValue.setInstanceEntityCharacteristic(this);
		}

	}

}
