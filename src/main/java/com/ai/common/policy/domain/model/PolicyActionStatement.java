package com.ai.common.policy.domain.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class PolicyActionStatement extends PolicyStatement {
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private PolicyActionOperator operator;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private PolicyAtomicAction action;
	
	public PolicyActionStatement(PolicyAtomicAction action) {
		this.setAction(action);
		action.setStatement(this);
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
