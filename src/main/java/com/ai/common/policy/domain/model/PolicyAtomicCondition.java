package com.ai.common.policy.domain.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("ATOMIC")
public class PolicyAtomicCondition extends PolicyCondition {
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL,mappedBy="condition")
	private PolicyConditionStatement statement;
	public PolicyAtomicCondition(PolicySet policyset) {
		super(policyset);
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
