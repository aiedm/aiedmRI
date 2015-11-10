package com.ai.common.policy.domain.model;

public class PolicyConditionStatement extends PolicyStatement{
	private PolicyConditionOperator operator;
	public PolicyConditionStatement() {
	}

	
	public PolicyOperator getOperator() {
		return this.operator;
	}

	
	public void setOperator(PolicyOperator operator) {
		this.operator=(PolicyConditionOperator)operator;
	}

}
