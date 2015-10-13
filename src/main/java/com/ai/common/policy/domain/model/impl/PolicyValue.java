package com.ai.common.policy.domain.model.impl;

import com.ai.common.policy.domain.model.interfaces.IPolicyValue;
import com.ai.common.rootentity.domain.model.impl.InstanceEntity;

public class PolicyValue extends InstanceEntity implements IPolicyValue {
	private long id;
	private String name;
	private String code;
	private String type;
	private String value;
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public PolicyValue() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public long getId() {
		return this.id;
	}

	@Override
	public void setId(long id) {
		this.id=id;
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

	@Override
	public boolean hasCharacteristic() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return this.value;
	}

	@Override
	public void setValue(String value) {
		this.value=value;
	}	

	@Override
	public String toPolicyString() {
		return this.getValue();
	}

}
