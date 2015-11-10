package com.ai.common.policy.domain.model;

import java.util.HashSet;
import java.util.Set;

public class PolicyConstValue extends PolicyValue{

	public PolicyConstValue() {
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
