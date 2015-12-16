package com.ai.common.policy.domain.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class PolicyConditionStatement extends PolicyStatement{
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private PolicyConditionOperator operator;
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private PolicyAtomicCondition condition;
	
	
	public PolicyConditionStatement(PolicyAtomicCondition condition) {
		this.setCondition(condition);
		condition.setStatement(this);
	}

	
	public PolicyOperator getOperator() {
		return this.operator;
	}

	
	public void setOperator(PolicyOperator operator) {
		this.operator=(PolicyConditionOperator)operator;
	}


	public PolicyAtomicCondition getCondition() {
		return condition;
	}


	public void setCondition(PolicyAtomicCondition condition) {
		this.condition = condition;
	}

}
