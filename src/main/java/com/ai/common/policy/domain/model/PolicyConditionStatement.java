package com.ai.common.policy.domain.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class PolicyConditionStatement extends PolicyStatement{
	@OneToOne
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
