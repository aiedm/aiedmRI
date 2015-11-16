package com.ai.common.policy.domain.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
@MappedSuperclass
public class PolicyAtomicAction extends PolicyAction{
	@OneToOne
	private PolicyActionStatement statement;
	public PolicyAtomicAction() {
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
