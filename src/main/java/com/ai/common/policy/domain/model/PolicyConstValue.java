package com.ai.common.policy.domain.model;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("CONST")
public class PolicyConstValue extends PolicyValue{

	public PolicyConstValue(PolicySet policyset) {
		super(policyset);
	}

	@Override
	public String toBodyString() {
		return this.getValue();
	}
	@Override
	public Set<PolicyVariable> getVariables() {
		return null;
	}
}
