package com.ai.common.policy.domain.model;

import java.util.HashSet;
import java.util.Set;

public class PolicyAtomicAction extends PolicyAction{
	private PolicyActionStatement statement;
	public PolicyAtomicAction() {
	}

	
	public String toBodyString() {
		return this.getStatement().toBodyString()+";\n";
	}

	
	public PolicyActionStatement getStatement() {
		return this.statement;
	}

	
	public void setStatement(PolicyActionStatement statement) {
		this.statement=statement;
	}

	
	public Set<PolicyVariable> getVariables() {
		Set<PolicyVariable> variables=new HashSet<PolicyVariable>();
		if (null!=this.getStatement().getVariables()){
			variables.addAll(this.getStatement().getVariables());
		}		
		return variables;
	}

}
