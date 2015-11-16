package com.ai.common.rootentity.domain.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class SpecInstanceEntityCharacterValue extends RootEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;	
	@ManyToOne
	private SpecInstanceEntityCharacter specInstanceEntityCharacteristic;
	
	private long characterValueInstanceId;
	@Column
	private CharacteristicSpecValue characteristicValue;
	@Column
	private String value;
	@Column
	private int action;
	
	public int getAction() {
		return action;
	}


	public void setAction(int action) {
		this.action = action;
	}	
	public SpecInstanceEntityCharacterValue(){
		
	}
			
	public SpecInstanceEntityCharacterValue(SpecInstanceEntityCharacter instanceEntityCharacteristic, CharacteristicSpecValue characteristicValue){
		this.setInstanceEntityCharacteristic(instanceEntityCharacteristic);
		this.setCharacteristicValue(characteristicValue);
	}
	
	
	public SpecInstanceEntityCharacter getInstanceEntityCharacteristic() {
		return this.specInstanceEntityCharacteristic;
	}

	
	public void setInstanceEntityCharacteristic(SpecInstanceEntityCharacter instanceEntityCharacteristic) {
		this.specInstanceEntityCharacteristic=instanceEntityCharacteristic;
	}

	
	public CharacteristicSpecValue getCharacteristicSpecValue() {
		return this.characteristicValue;
	}

	
	public void setCharacteristicValue(CharacteristicSpecValue characteristicValue) {
		this.characteristicValue=characteristicValue;
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
		this.characterValueInstanceId=characterValueInstanceId;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}

}
