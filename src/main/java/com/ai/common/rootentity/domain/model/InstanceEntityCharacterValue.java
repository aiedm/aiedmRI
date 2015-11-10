package com.ai.common.rootentity.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class InstanceEntityCharacterValue extends RootEntity{
	private InstanceEntityCharacter instanceEntityCharacteristic;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long characterValueInstanceId;
	@Column
	private long characteristicValueId;
	@Column
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
			
	public InstanceEntityCharacterValue(InstanceEntityCharacter instanceEntityCharacteristic, long characteristicValueId){
		this.setInstanceEntityCharacteristic(instanceEntityCharacteristic);
		this.setCharacteristicValueId(characteristicValueId);
	}
	
	
	public InstanceEntityCharacter getInstanceEntityCharacteristic() {
		return this.instanceEntityCharacteristic;
	}

	
	public void setInstanceEntityCharacteristic(InstanceEntityCharacter instanceEntityCharacteristic) {
		this.instanceEntityCharacteristic=instanceEntityCharacteristic;
	}

	
	public long getCharacteristicSpecValueId() {
		return this.characteristicValueId;
	}

	
	public void setCharacteristicValueId(long characteristicValueId) {
		this.characteristicValueId=characteristicValueId;
	}

	
	public String getInputedValue() {
		return this.value;
	}

	
	public void setInputedValue(String value) {
		this.value=value;
	}

	
	public long getCharacterValueInstanceId() {
		return this.characterValueInstanceId;
	}

	
	public void setCharacterValueInstanceId(long characterValueInstanceId) {
		this.characteristicValueId=characterValueInstanceId;
	}

}
