package com.ai.common.rootentity.domain.model.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.ai.common.rootentity.domain.model.interfaces.IInstanceEntity;
import com.ai.common.rootentity.domain.model.interfaces.IInstanceEntityCharacter;
import com.ai.common.rootentity.domain.model.interfaces.IInstanceEntityCharacterValue;
@Component
public class InstanceEntityCharacter extends RootEntity implements IInstanceEntityCharacter {
	private long characterInstanceId;
	private IInstanceEntity instanceEntity;
	private long characteristicSpecId;
	private Set<IInstanceEntityCharacterValue> characteristicInstanceValues=new HashSet<IInstanceEntityCharacterValue>();
	
	private int action;
	
	public int getAction() {
		return action;
	}


	public void setAction(int action) {
		this.action = action;
	}
	@Override
	public IInstanceEntity getOwnerInstance() {
		return this.instanceEntity;
	}

	@Override
	public void setOwnerInstance(IInstanceEntity instanceEntity) {
		this.instanceEntity=instanceEntity;
	}

	@Override
	public long getCharacteristicSpecId() {
		return this.characteristicSpecId;
	}

	@Override
	public void setCharacteristicSpecId(long characteristic) {
		this.characteristicSpecId=characteristic;
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

	@Override
	public long getCharacterInstanceId() {
		return this.characterInstanceId;
	}

	@Override
	public void setCharacterInstanceId(long characterInstanceId) {
		this.characterInstanceId=characterInstanceId;
	}

}
