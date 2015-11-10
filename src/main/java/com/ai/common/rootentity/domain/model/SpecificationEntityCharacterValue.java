package com.ai.common.rootentity.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class SpecificationEntityCharacterValue extends RootEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private SpecificationEntityCharacteristic specificationEntityCharacteristic;
	private CharacteristicSpecValue characteristicValue;
	
	public long getId() {
		return this.id;
	}

	
	public void setId(long id) {
		this.id=id;
	}

	
	public SpecificationEntityCharacteristic getOwnerCharacteristic() {
		return this.specificationEntityCharacteristic;
	}

	
	public void setOwnerCharacteristic(SpecificationEntityCharacteristic specificationEntityCharacteristic) {
		this.specificationEntityCharacteristic=specificationEntityCharacteristic;
		
	}

	
	public CharacteristicSpecValue getCharacteristicValue() {
		return this.characteristicValue;
	}

	
	public void setCharacteristicValue(CharacteristicSpecValue characteristicValue) {
		this.characteristicValue=characteristicValue;
	}


}
