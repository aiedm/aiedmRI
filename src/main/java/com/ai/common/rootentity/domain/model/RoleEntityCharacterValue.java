package com.ai.common.rootentity.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Entity
public class RoleEntityCharacterValue extends RootEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne
	private RoleEntityCharacteristic roleEntityCharacteristic;
	@OneToOne
	private CharacteristicSpecValue characteristicSpecValue;

	
	public RoleEntityCharacteristic getOwnerCharacteristic() {
		return this.roleEntityCharacteristic;
	}

	
	public void setOwnerCharacteristic(RoleEntityCharacteristic roleEntityCharacteristic) {
		this.roleEntityCharacteristic=roleEntityCharacteristic;
		
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
