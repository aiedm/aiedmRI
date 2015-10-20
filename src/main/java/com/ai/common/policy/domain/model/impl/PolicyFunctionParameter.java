package com.ai.common.policy.domain.model.impl;

import com.ai.common.policy.domain.model.interfaces.IPolicyFunction;
import com.ai.common.policy.domain.model.interfaces.IPolicyFunctionParameter;
import com.ai.common.rootentity.domain.model.impl.InstanceEntity;

public class PolicyFunctionParameter extends InstanceEntity implements IPolicyFunctionParameter {
	private long id;
	private String name;
	private String code;
	private IPolicyFunction function;
	private String paramType;
	
	public PolicyFunctionParameter() {
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
	public IPolicyFunction getFunction() {
		return this.function;
	}

	@Override
	public void setFunction(IPolicyFunction function) {
		this.function=function;
	}

	@Override
	public String getParameterType() {
		return this.paramType;
	}

	@Override
	public void setParameterType(String paramType) {
		this.paramType=paramType;
	}

}
