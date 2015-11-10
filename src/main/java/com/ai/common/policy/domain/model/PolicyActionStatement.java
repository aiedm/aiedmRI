package com.ai.common.policy.domain.model;


public class PolicyActionStatement extends PolicyStatement {
	private PolicyActionOperator operator;
	public PolicyActionStatement() {
	}

	
	public PolicyOperator getOperator() {
		return this.operator;
	}

	
	public void setOperator(PolicyOperator operator) {
		this.operator=(PolicyActionOperator)operator;
	}

}
