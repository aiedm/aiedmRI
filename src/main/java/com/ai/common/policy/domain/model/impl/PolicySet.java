package com.ai.common.policy.domain.model.impl;

import com.ai.common.policy.domain.model.interfaces.IPolicySet;
import com.ai.common.rootentity.domain.model.impl.InstanceEntity;

public abstract class PolicySet extends InstanceEntity implements IPolicySet {
	private long id;
	private String name;
	private String code;
	public PolicySet() {
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
		return false;
	}

	@Override
	public abstract String toPolicyString();

}
