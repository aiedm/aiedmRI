package com.ai.common.rootentity.domain.model.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.ai.common.rootentity.domain.model.interfaces.IInstanceEntity;
import com.ai.common.rootentity.domain.model.interfaces.IInstanceEntityCharacteristic;
@Component
public abstract class InstanceEntity extends RootEntity implements IInstanceEntity {
	private  Set<IInstanceEntityCharacteristic> instanceEntityCharacteristics=new HashSet<IInstanceEntityCharacteristic>();
	
	public abstract boolean hasCharacteristic();
	
	protected Set<IInstanceEntityCharacteristic> getCharacteristics() {
		return this.instanceEntityCharacteristics;
	}

	protected void addCharacteristic(IInstanceEntityCharacteristic instanceEntityCharacteristic) {
		this.instanceEntityCharacteristics.add(instanceEntityCharacteristic);
		if (null==instanceEntityCharacteristic.getOwnerInstance()){
			instanceEntityCharacteristic.setOwnerInstance(this);
		}
	}

}
