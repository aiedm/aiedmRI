package com.ai.common.policy.domain.model;

import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

@MappedSuperclass
public class PolicyActionStatement extends PolicyStatement {
	@OneToOne
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
