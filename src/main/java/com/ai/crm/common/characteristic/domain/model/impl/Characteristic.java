package com.ai.crm.common.characteristic.domain.model.impl;

import java.util.Set;

import org.springframework.stereotype.Component;

import com.ai.crm.common.characteristic.domain.model.interfaces.ICharacteristic;
import com.ai.crm.common.characteristic.domain.model.interfaces.ICharacteristicValue;
@Component
public class Characteristic implements ICharacteristic {
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

	private Set<ICharacteristicValue> values=new java.util.HashSet<ICharacteristicValue>();

	@Override
	public Set<ICharacteristicValue> getValues() {
		return this.values;
	}

	@Override
	public void addValue(ICharacteristicValue value) {
		if (null!=value){
			values.add(value);
		}
	}

}
