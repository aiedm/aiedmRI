package com.ai.common.policy.domain.model.impl;

import com.ai.common.policy.domain.model.interfaces.IPolicyConstValue;

public class PolicyConstValue extends PolicyValue implements IPolicyConstValue {

	public PolicyConstValue() {
	}

	@Override
	public String toBodyString() {
		return this.getValue();
	}

}
