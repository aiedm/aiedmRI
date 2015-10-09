package com.ai.common.rootentity.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.ai.common.rootentity.interfaces.ICharacteristicSpec;
import com.ai.common.rootentity.interfaces.ICharacteristicSpecValue;
import com.ai.common.rootentity.interfaces.IRoleEntityCharacteristic;
import com.ai.common.rootentity.interfaces.ISpecificationEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Component
public class RoleEntityCharacteristic extends RootEntity implements IRoleEntityCharacteristic {
	@JsonIgnore
	private ISpecificationEntity specificationEntity;
	private ICharacteristicSpec characteristic;
	private Set<ICharacteristicSpecValue> characteristicValues=new HashSet<ICharacteristicSpecValue>();
	
	@Override
	public ISpecificationEntity getOwnerRole() {
		return this.specificationEntity;
	}

	@Override
	public void setOwnerRole(ISpecificationEntity specificationEntity) {
		this.specificationEntity=specificationEntity;
	}

	@Override
	public ICharacteristicSpec getCharacteristic() {
		return this.characteristic;
	}

	@Override
	public void setCharacteristic(ICharacteristicSpec characteristic) {
		this.characteristic=characteristic;
	}

	@Override
	public Set<ICharacteristicSpecValue> getCharacteristicValues() {
		return this.characteristicValues;
	}

	@Override
	public void addCharacteristicValue(ICharacteristicSpecValue characteristicValue) {
		characteristicValues.add(characteristicValue);		
		if (null==characteristicValue.getCharacteristic()){
			characteristicValue.setCharacteristic(this.getCharacteristic());
		}
	}

}
