package com.ai.common.policy.domain.model;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@MappedSuperclass
public class PolicyActionStatement extends PolicyStatement {
	@Transient
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
