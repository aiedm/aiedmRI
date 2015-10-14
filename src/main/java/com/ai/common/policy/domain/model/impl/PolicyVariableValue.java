package com.ai.common.policy.domain.model.impl;

import com.ai.common.policy.domain.model.interfaces.IPolicyVariable;
import com.ai.common.policy.domain.model.interfaces.IPolicyVariableValue;

public class PolicyVariableValue extends PolicyValue implements IPolicyVariableValue {
	private IPolicyVariable variable;
	public PolicyVariableValue() {
	}

	@Override
	public IPolicyVariable getVariable() {
		return this.variable;
	}

	@Override
	public void setVariable(IPolicyVariable variable) {
		this.variable=variable;
	}
	
	public String getValue(){
		return this.getVariable().getCode();
	}
	
	public void setValue(String value){
		// do nothing
	}

}
