package com.ai.common.policy.domain.model;

import com.ai.common.rootentity.domain.model.InstanceEntity;

public class PolicySetParameter extends InstanceEntity{
	private long id;
	private PolicyVariable variable;
	private PolicySet policySet;

	public PolicySetParameter() {
	}

	
	public long getId() {
		return this.id;
	}

	
	public void setId(long id) {
		this.id=id;
	}

	
	public PolicyVariable getVariable() {
		return this.variable;
	}

	
	public void setVariable(PolicyVariable variable) {
		this.variable=variable;
	}

	
	public PolicySet getPolicySet() {
		return this.policySet;
	}

	
	public void setPolicySet(PolicySet policySet) {
		this.policySet=policySet;
	}

}
