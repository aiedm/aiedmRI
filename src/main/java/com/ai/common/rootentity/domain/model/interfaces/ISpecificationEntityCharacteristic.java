package com.ai.common.rootentity.domain.model.interfaces;

import java.util.Set;


public interface ISpecificationEntityCharacteristic  extends IRootEntity{
	ISpecificationEntity getOwnerSpecification();
	void setOwnerSpecification(ISpecificationEntity specificationEntity);
	ICharacteristicSpec getCharacteristic();
	void setCharacteristic(ICharacteristicSpec characteristic);
	Set<ICharacteristicSpecValue> getCharacteristicValues();
	void addCharacteristicValue(ICharacteristicSpecValue characteristicValue);
}
