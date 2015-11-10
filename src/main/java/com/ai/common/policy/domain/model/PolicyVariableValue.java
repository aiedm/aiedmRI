package com.ai.common.policy.domain.model;

import java.util.HashSet;
import java.util.Set;


public class PolicyVariableValue extends PolicyValue{
	private PolicyVariable variable;
	public PolicyVariableValue() {
	}

	
	public PolicyVariable getVariable() {
		return this.variable;
	}

	
	public void setVariable(PolicyVariable variable) {
		this.variable=variable;
	}

	
	public String toBodyString() {
		return this.getVariable().getCode();
	}

	
	public Set<PolicyVariable> getVariables() {
		Set<PolicyVariable> variables=new HashSet<PolicyVariable>();
		variables.add(this.getVariable());		
		return variables;
	}

}
