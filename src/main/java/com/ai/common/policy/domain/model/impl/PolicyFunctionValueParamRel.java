package com.ai.common.policy.domain.model.impl;

import com.ai.common.policy.domain.model.interfaces.IPolicyFunctionParameter;
import com.ai.common.policy.domain.model.interfaces.IPolicyFunctionValue;
import com.ai.common.policy.domain.model.interfaces.IPolicyFunctionValueParamRel;
import com.ai.common.policy.domain.model.interfaces.IPolicyValue;
import com.ai.common.rootentity.domain.model.impl.InstanceEntity;

public class PolicyFunctionValueParamRel extends InstanceEntity implements IPolicyFunctionValueParamRel {
	private IPolicyFunctionValue functionValue;
	private IPolicyFunctionParameter param;
	private IPolicyValue value;
	public PolicyFunctionValueParamRel() {
	}

	@Override
	public IPolicyFunctionValue getFunctionValue() {
		return this.functionValue;
	}

	@Override
	public void setFunctionValue(IPolicyFunctionValue functionValue) {
		this.functionValue=functionValue;
	}

	@Override
	public IPolicyFunctionParameter getParameter() {
		return this.param;
	}

	@Override
	public void setParameter(IPolicyFunctionParameter param) {
		this.param=param;
	}

	@Override
	public IPolicyValue getValue() {
		return this.value;
	}

	@Override
	public void setValue(IPolicyValue value) {
		this.value=value;
	}

	@Override
	public String toBodyString() {
		IPolicyValue value=this.getValue();		
		return value.toBodyString();
	}

}
