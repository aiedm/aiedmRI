package com.ai.common.policy.domain.model;

import com.ai.common.rootentity.domain.model.InstanceEntity;

public class PolicyFunctionParameter extends InstanceEntity{
	private long id;
	private String name;
	private String code;
	private PolicyFunction function;
	private String paramType;
	
	public PolicyFunctionParameter() {
	}

	
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

	
	public PolicyFunction getFunction() {
		return this.function;
	}

	
	public void setFunction(PolicyFunction function) {
		this.function=function;
	}

	
	public String getParameterType() {
		return this.paramType;
	}

	
	public void setParameterType(String paramType) {
		this.paramType=paramType;
	}

}
