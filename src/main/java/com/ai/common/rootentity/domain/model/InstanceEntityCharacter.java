package com.ai.common.rootentity.domain.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class InstanceEntityCharacter extends RootEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long characterInstanceId;
	
	private InstanceEntity instanceEntity;
	
	@Column
	private long characteristicSpecId;
	
	private Set<InstanceEntityCharacterValue> characteristicInstanceValues=new LinkedHashSet<InstanceEntityCharacterValue>();
	
	private int action;
	
	public int getAction() {
		return action;
	}


	public void setAction(int action) {
		this.action = action;
	}
	
	public InstanceEntity getOwnerInstance() {
		return this.instanceEntity;
	}

	
	public void setOwnerInstance(InstanceEntity instanceEntity) {
		this.instanceEntity=instanceEntity;
	}

	
	public long getCharacteristicSpecId() {
		return this.characteristicSpecId;
	}

	
	public void setCharacteristicSpecId(long characteristic) {
		this.characteristicSpecId=characteristic;
	}

	
	public Set<InstanceEntityCharacterValue> getCharacteristicInstanceValues() {
		return this.characteristicInstanceValues;
	}

	
	public void addCharacteristicInstanceValue(InstanceEntityCharacterValue characteristicInstanceValue) {
		this.characteristicInstanceValues.add(characteristicInstanceValue);
		if (null==characteristicInstanceValue.getInstanceEntityCharacteristic()){
			characteristicInstanceValue.setInstanceEntityCharacteristic(this);
		}

	}

	
	public long getCharacterInstanceId() {
		return this.characterInstanceId;
	}

	
	public void setCharacterInstanceId(long characterInstanceId) {
		this.characterInstanceId=characterInstanceId;
	}

}
