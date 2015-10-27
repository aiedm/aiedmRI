package com.ai.common.policy.domain.model.impl;

import java.util.HashSet;
import java.util.Set;

import com.ai.common.policy.domain.model.interfaces.IPolicyConstValue;
import com.ai.common.policy.domain.model.interfaces.IPolicyVariable;

public class PolicyConstValue extends PolicyValue implements IPolicyConstValue {

	public PolicyConstValue() {
	}

	@Override
	public String toBodyString() {
		return this.getValue();
	}
	@Override
	public Set<IPolicyVariable> getVariables() {
		return null;
	}
}
