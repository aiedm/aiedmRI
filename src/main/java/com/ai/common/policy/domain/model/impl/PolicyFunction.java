package com.ai.common.policy.domain.model.impl;

import java.util.HashSet;
import java.util.Set;

import com.ai.common.policy.domain.model.interfaces.IPolicyFunction;
import com.ai.common.policy.domain.model.interfaces.IPolicyFunctionParameter;
import com.ai.common.rootentity.domain.model.impl.InstanceEntity;

public class PolicyFunction extends InstanceEntity implements IPolicyFunction {
	private long id;
	private String name;
	private String code;
	private String returnType;
	Set<IPolicyFunctionParameter> parameters=new HashSet<IPolicyFunctionParameter>();
	public PolicyFunction() {
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
	public Set<IPolicyFunctionParameter> getParameters() {
		return this.parameters;
	}

	@Override
	public void addParameter(IPolicyFunctionParameter param) {
		if(null!=param){
			this.parameters.add(param);
		}
	}

	@Override
	public String returnType() {
		return this.returnType;
	}

	@Override
	public void setReturnType(String type) {
		this.returnType=type;
	}

}
