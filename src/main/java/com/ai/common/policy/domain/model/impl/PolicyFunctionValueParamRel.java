package com.ai.common.policy.domain.model.impl;

import com.ai.common.policy.domain.model.interfaces.IPolicyFunctionParameter;
import com.ai.common.policy.domain.model.interfaces.IPolicyFunctionValue;
import com.ai.common.policy.domain.model.interfaces.IPolicyFunctionValueParamRel;
import com.ai.common.policy.domain.model.interfaces.IPolicyVariable;
import com.ai.common.rootentity.domain.model.impl.InstanceEntity;

public class PolicyFunctionValueParamRel extends InstanceEntity implements IPolicyFunctionValueParamRel {
	private IPolicyFunctionValue functionValue;
	private IPolicyFunctionParameter param;
	private IPolicyVariable variableValue;
	private String value;
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
	public IPolicyVariable getVaraibleValueRef() {
		return this.variableValue;
	}

	@Override
	public void setVaraibleValueRef(IPolicyVariable variableValue) {
		this.variableValue=variableValue;
	}

	@Override
	public String getValue() {
		return this.value;
	}

	@Override
	public void setValue(String value) {
		this.value=value;
	}

	@Override
	public boolean hasCharacteristic() {
		return false;
	}

}
