package com.ai.common.policy.domain.model.impl;

import com.ai.common.policy.domain.model.interfaces.IPolicyFunctionParameter;
import com.ai.common.policy.domain.model.interfaces.IPolicyFunctionVariable;
import com.ai.common.policy.domain.model.interfaces.IPolicyFunctionVariableParamRel;
import com.ai.common.policy.domain.model.interfaces.IPolicyVariable;
import com.ai.common.rootentity.domain.model.impl.InstanceEntity;

public class PolicyFunctionVariableParamRel extends InstanceEntity implements IPolicyFunctionVariableParamRel {
	private IPolicyFunctionVariable variable;
	private IPolicyFunctionParameter param;
	private IPolicyVariable variableValue;
	private String value;
	public PolicyFunctionVariableParamRel() {
	}

	@Override
	public IPolicyFunctionVariable getFunctionVariable() {
		return this.variable;
	}

	@Override
	public void setFunctionVariable(IPolicyFunctionVariable variable) {
		this.variable=variable;
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
