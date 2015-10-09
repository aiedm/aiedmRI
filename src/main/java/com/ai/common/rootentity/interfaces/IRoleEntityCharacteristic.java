package com.ai.common.rootentity.interfaces;

import java.util.Set;


public interface IRoleEntityCharacteristic  extends IRootEntity{
	ISpecificationEntity getOwnerRole();
	void setOwnerRole(ISpecificationEntity specificationEntity);
	ICharacteristicSpec getCharacteristic();
	void setCharacteristic(ICharacteristicSpec characteristic);
	Set<ICharacteristicSpecValue> getCharacteristicValues();
	void addCharacteristicValue(ICharacteristicSpecValue characteristicValue);
}
