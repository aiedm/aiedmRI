package com.ai.common.policy.domain.model;

import java.util.Set;

import com.ai.common.rootentity.domain.model.InstanceEntity;

public abstract class PolicyCondition extends InstanceEntity {
	private long id;
	private String name;
	private String code;

	
	public long getId() {
		return this.id;
	}

	
	public void setId(long id) {
		this.id=id;
	}

	
	public String getName() {
		return this.name;
	}

	
	public void setName(String name) {
		this.name=name;
	}

	
	public String getCode() {
		return this.code;
	}

	
	public void setCode(String code) {
		this.code=code;
	}
	
	
	public abstract String toBodyString();	
	
	
	public abstract Set<PolicyVariable> getVariables();
}
