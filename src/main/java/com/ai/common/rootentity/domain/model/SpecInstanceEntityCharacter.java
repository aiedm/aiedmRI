package com.ai.common.rootentity.domain.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@MappedSuperclass
public abstract class SpecInstanceEntityCharacter extends RootEntity {
	@OneToOne
	private CharacteristicSpec characteristicSpec;
	
	@Transient
	private Set<SpecInstanceEntityCharacterValue> characteristicInstanceValues=new LinkedHashSet<SpecInstanceEntityCharacterValue>();
	
	private int action;
	
	public int getAction() {
		return action;
	}


	public void setAction(int action) {
		this.action = action;
	}
	
	public CharacteristicSpec getCharacteristicSpec() {
		return this.characteristicSpec;
	}

	
	public void setCharacteristicSpec(CharacteristicSpec characteristic) {
		this.characteristicSpec=characteristic;
	}

	
	public Set<SpecInstanceEntityCharacterValue> getCharacteristicInstanceValues() {
		return this.characteristicInstanceValues;
	}

	
	public void addCharacteristicInstanceValue(SpecInstanceEntityCharacterValue characteristicInstanceValue) {
		this.characteristicInstanceValues.add(characteristicInstanceValue);
		if (null==characteristicInstanceValue.getInstanceEntityCharacteristic()){
			characteristicInstanceValue.setInstanceEntityCharacteristic(this);
		}

	}


	public abstract long getId() ;

	public abstract void setId(long id);
	
	public abstract SpecInstanceEntityCharacterValue newCharacterValue(); 
	
	public abstract void addInstanceEntityCharacterValue(SpecInstanceEntityCharacterValue characteristicInstanceValue);

}
