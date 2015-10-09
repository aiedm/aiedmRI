package com.ai.common.rootentity.interfaces;

import java.util.Set;

public interface ISpecificationEntity extends IRootEntity {
	Set<ICharacteristicSpec> getCharacteristSpecs();
	void addCharacteristSpec(ICharacteristicSpec characteristicSpec);
	String getName();
	void setName(String name);
	String getCode();
	void setCode(String code);
}
