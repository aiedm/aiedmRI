package com.ai.common.policy.domain.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class PolicyAtomicCondition extends PolicyCondition {
	private PolicyConditionStatement statement;
	public PolicyAtomicCondition() {
	}

	
	public PolicyConditionStatement getStatement() {
		return this.statement;
	}

	
	public void setStatement(PolicyConditionStatement statement) {
		this.statement=statement;
	}

	
	public String toBodyString() {
		return this.getStatement().toBodyString();
	}

	
	public Set<PolicyVariable> getVariables() {
		Set<PolicyVariable> variables=new HashSet<PolicyVariable>();
		variables.addAll(this.getStatement().getVariables());
		return variables;
	}
}
