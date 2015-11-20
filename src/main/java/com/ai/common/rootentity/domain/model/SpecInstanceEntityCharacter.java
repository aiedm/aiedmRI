package com.ai.common.rootentity.domain.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@MappedSuperclass
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class SpecInstanceEntityCharacter extends RootEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Transient
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


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}
	
	public abstract SpecInstanceEntityCharacterValue newCharacterValue(); 

}
