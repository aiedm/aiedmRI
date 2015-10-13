package com.ai.common.policy.domain.model.impl;

import com.ai.common.policy.domain.model.interfaces.IPolicyFunctionParameter;
import com.ai.common.policy.domain.model.interfaces.IPolicyFunctionVariable;
import com.ai.common.policy.domain.model.interfaces.IPolicyFunctionVariableParamRel;
import com.ai.common.policy.domain.model.interfaces.IPolicyVariable;
import com.ai.common.rootentity.domain.model.impl.InstanceEntity;

public class PolicyFunctionVariableParamRel extends InstanceEntity implements IPolicyFunctionVariableParamRel {

	public PolicyFunctionVariableParamRel() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public IPolicyFunctionVariable getFunctionVariable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setFunctionVariable(IPolicyFunctionVariable variable) {
		// TODO Auto-generated method stub

	}

	@Override
	public IPolicyFunctionParameter getParameter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setParameter(IPolicyFunctionParameter param) {
		// TODO Auto-generated method stub

	}

	@Override
	public IPolicyVariable getVaraibleValueRef() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setVaraibleValueRef(IPolicyVariable ariableValue) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object getValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setValue(Object value) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean hasCharacteristic() {
		return false;
	}

}
