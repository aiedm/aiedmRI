package com.ai.common.policy.domain.model.impl;

import com.ai.common.policy.domain.model.interfaces.IPolicyAction;
import com.ai.common.rootentity.domain.model.impl.InstanceEntity;

public abstract class PolicyAction extends InstanceEntity implements IPolicyAction {
	private long id;
	private String name;
	private String code;

	@Override
	public boolean hasCharacteristic() {
		return false;
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
	public abstract String toPolicyString();

}
