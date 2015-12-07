package com.ai.common.rootentity.domain.model;

import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@MappedSuperclass
public abstract class SpecInstanceEntityCharacterValue extends RootEntity{	
	@Transient
	private SpecInstanceEntityCharacter specInstanceEntityCharacteristic;
	@OneToOne
	private CharacteristicSpecValue characteristicValue;
		
	private String value;
	
	private int action;
	
	public int getAction() {
		return action;
	}


	public void setAction(int action) {
		this.action = action;
	}	
	public SpecInstanceEntityCharacterValue(){
		
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

	public abstract long getId() ;

	public abstract void setId(long id);

}
