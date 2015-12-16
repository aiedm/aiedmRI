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
public class PolicyAtomicAction extends PolicyAction{
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL,mappedBy="action")
	private PolicyActionStatement statement;
	public PolicyAtomicAction(PolicySet policyset) {
		super(policyset);
	}

	
	public String toBodyString() {
		return this.getStatement().toBodyString()+";\n";
	}

	
	public PolicyActionStatement getStatement() {
		return this.statement;
	}

	
	public void setStatement(PolicyActionStatement statement) {
		this.statement=statement;
	}

	
	public Set<PolicyVariable> getVariables() {
		Set<PolicyVariable> variables=new HashSet<PolicyVariable>();
		if (null!=this.getStatement().getVariables()){
			variables.addAll(this.getStatement().getVariables());
		}		
		return variables;
	}

}
