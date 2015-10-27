package com.ai.common.policy.domain.model.impl;

import java.util.HashSet;
import java.util.Set;

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

	@Override
	public String toBodyString() {
		return this.getVariable().getCode();
	}

	@Override
	public Set<IPolicyVariable> getVariables() {
		Set<IPolicyVariable> variables=new HashSet<IPolicyVariable>();
		variables.add(this.getVariable());		
		return variables;
	}

}
