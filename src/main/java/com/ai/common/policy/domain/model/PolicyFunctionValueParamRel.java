package com.ai.common.policy.domain.model;

import com.ai.common.rootentity.domain.model.InstanceEntity;

public class PolicyFunctionValueParamRel extends InstanceEntity{
	private PolicyFunctionValue functionValue;
	private PolicyFunctionParameter param;
	private PolicyValue value;
	public PolicyFunctionValueParamRel() {
	}

	
	public PolicyFunctionValue getFunctionValue() {
		return this.functionValue;
	}

	
	public void setFunctionValue(PolicyFunctionValue functionValue) {
		this.functionValue=functionValue;
	}

	
	public PolicyFunctionParameter getParameter() {
		return this.param;
	}

	
	public void setParameter(PolicyFunctionParameter param) {
		this.param=param;
	}

	
	public PolicyValue getValue() {
		return this.value;
	}

	
	public void setValue(PolicyValue value) {
		this.value=value;
	}

	
	public String toBodyString() {
		PolicyValue value=this.getValue();		
		return value.toBodyString();
	}

}
