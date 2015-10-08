package com.ai.crm.common.rootentity.impl;

import java.util.Set;

import org.springframework.stereotype.Component;

import com.ai.crm.common.rootentity.interfaces.ICharacteristicSpec;
import com.ai.crm.common.rootentity.interfaces.ICharacteristicSpecValue;
@Component
public class CharacteristicSpec extends RootEntity implements ICharacteristicSpec {
	private long id;
	private String name;
	private String code;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	private Set<ICharacteristicSpecValue> values=new java.util.HashSet<ICharacteristicSpecValue>();

	@Override
	public Set<ICharacteristicSpecValue> getValues() {
		return this.values;
	}

	@Override
	public void addValue(ICharacteristicSpecValue value) {
		if (null!=value){
			values.add(value);
		}
	}

}
