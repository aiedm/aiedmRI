package com.ai.common.policy.domain.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class PolicyActionStatement extends PolicyStatement {
	@OneToOne
	private PolicyActionOperator operator;
	
	@ManyToOne
	private PolicyAtomicAction action;
	
	public PolicyActionStatement() {
	}

	
	public PolicyOperator getOperator() {
		return this.operator;
	}

	
	public void setOperator(PolicyOperator operator) {
		this.operator=(PolicyActionOperator)operator;
	}


	public PolicyAtomicAction getAction() {
		return action;
	}


	public void setAction(PolicyAtomicAction action) {
		this.action = action;
	}

}
