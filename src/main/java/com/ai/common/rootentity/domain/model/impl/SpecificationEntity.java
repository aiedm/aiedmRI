package com.ai.common.rootentity.domain.model.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.ai.common.rootentity.domain.model.interfaces.ICharacteristicSpec;
import com.ai.common.rootentity.domain.model.interfaces.ISpecificationEntity;
@Component
public class SpecificationEntity extends RootEntity implements ISpecificationEntity {
	private Set<ICharacteristicSpec> characteristSpecs=new HashSet<ICharacteristicSpec>();
	private String name;
	private String code;
	

	@Override
	public Set<ICharacteristicSpec> getCharacteristSpecs() {
		return this.characteristSpecs;
	}

	@Override
	public void addCharacteristSpec(ICharacteristicSpec characteristicSpec) {
		if (null!=characteristicSpec){
			this.characteristSpecs.add(characteristicSpec);
		}
		
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name=name;
	}

	@Override
	public String getCode() {
		return this.code;
	}

	@Override
	public void setCode(String code) {
		this.code=code;
	}

}
