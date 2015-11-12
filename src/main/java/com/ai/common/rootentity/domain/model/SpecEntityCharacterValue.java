package com.ai.common.rootentity.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Entity
@Component
public class SpecEntityCharacterValue extends RootEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne
	private SpecEntityCharacteristic specificationEntityCharacteristic;
	@OneToOne
	private CharacteristicSpecValue characteristicSpecValue;

	
	public SpecEntityCharacteristic getOwnerCharacteristic() {
		return this.specificationEntityCharacteristic;
	}

	
	public void setOwnerCharacteristic(SpecEntityCharacteristic specificationEntityCharacteristic) {
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
