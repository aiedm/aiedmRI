package com.ai.common.rootentity.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

@Entity
public class SpecEntityCharacterValue extends RootEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne
	private SpecEntityCharacter specificationEntityCharacteristic;
	@OneToOne
	private CharacteristicSpecValue characteristicSpecValue;

	
	public SpecEntityCharacter getOwnerCharacteristic() {
		return this.specificationEntityCharacteristic;
	}

	
	public void setOwnerCharacteristic(SpecEntityCharacter specificationEntityCharacteristic) {
		this.specificationEntityCharacteristic=specificationEntityCharacteristic;
		
	}

	
	public CharacteristicSpecValue getCharacteristicValue() {
		return this.characteristicSpecValue;
	}

	
	public void setCharacteristicValue(CharacteristicSpecValue characteristicValue) {
		this.characteristicSpecValue=characteristicValue;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


}
