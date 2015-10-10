package com.ai.common.rootentity.domain.model.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.ai.common.rootentity.domain.model.interfaces.ICharacteristicSpec;
import com.ai.common.rootentity.domain.model.interfaces.ICharacteristicSpecValue;
import com.ai.common.rootentity.domain.model.interfaces.ISpecificationEntity;
import com.ai.common.rootentity.domain.model.interfaces.ISpecificationEntityCharacteristic;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Component
public class SpecificationEntityCharacteristic extends RootEntity implements ISpecificationEntityCharacteristic {
	@JsonIgnore
	private ISpecificationEntity specificationEntity;
	private ICharacteristicSpec characteristic;
	private Set<ICharacteristicSpecValue> characteristicValues=new HashSet<ICharacteristicSpecValue>();
	@Override
	public ISpecificationEntity getOwnerSpecification() {
		return this.specificationEntity;
	}

	@Override
	public void setOwnerSpecification(ISpecificationEntity specificationEntity) {
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
