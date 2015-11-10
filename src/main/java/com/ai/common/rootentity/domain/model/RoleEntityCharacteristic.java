package com.ai.common.rootentity.domain.model;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Component
public class RoleEntityCharacteristic extends RootEntity{
	@JsonIgnore
	private SpecificationEntity specificationEntity;
	private CharacteristicSpec characteristic;
	private Set<CharacteristicSpecValue> characteristicValues=new LinkedHashSet<CharacteristicSpecValue>();
	
	
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

	
	public Set<CharacteristicSpecValue> getCharacteristicValues() {
		return this.characteristicValues;
	}

	
	public void addCharacteristicValue(CharacteristicSpecValue characteristicValue) {
		characteristicValues.add(characteristicValue);		
		if (null==characteristicValue.getCharacteristic()){
			characteristicValue.setCharacteristic(this.getCharacteristic());
		}
	}

}
