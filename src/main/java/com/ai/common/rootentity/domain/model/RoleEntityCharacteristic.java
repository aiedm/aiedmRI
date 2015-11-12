package com.ai.common.rootentity.domain.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class RoleEntityCharacteristic extends RootEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@OneToOne
	private SpecificationEntity specificationEntity;
	@OneToOne
	private CharacteristicSpec characteristic;
	@OneToMany(mappedBy="characteristicSpecValue",fetch=FetchType.LAZY)
	private Set<RoleEntityCharacterValue> characteristicValues=new LinkedHashSet<RoleEntityCharacterValue>();
	
	
	public SpecificationEntity getOwnerRole() {
		return this.specificationEntity;
	}

	
	public void setOwnerRole(SpecificationEntity specificationEntity) {
		this.specificationEntity=specificationEntity;
	}

	
	public CharacteristicSpec getCharacteristic() {
		return this.characteristic;
	}

	
	public void setCharacteristic(CharacteristicSpec characteristic) {
		this.characteristic=characteristic;
	}

	
	public Set<RoleEntityCharacterValue> getCharacteristicValues() {
		return this.characteristicValues;
	}

	
	public void addCharacteristicValue(RoleEntityCharacterValue characteristicValue) {
		characteristicValues.add(characteristicValue);		
		if (null==characteristicValue.getOwnerCharacteristic()){
			characteristicValue.setOwnerCharacteristic(this);
		}
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}

}
