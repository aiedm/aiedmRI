package com.ai.common.policy.domain.model.impl;

import com.ai.common.policy.domain.model.interfaces.IPolicyActionOperator;
import com.ai.common.policy.domain.model.interfaces.IPolicyActionStatement;
import com.ai.common.policy.domain.model.interfaces.IPolicyOperator;

public class PolicyActionStatement extends PolicyStatement implements IPolicyActionStatement {
	private IPolicyActionOperator operator;
	public PolicyActionStatement() {
	}

	@Override
	public IPolicyOperator getOperator() {
		return this.operator;
	}

	@Override
	public void setOperator(IPolicyOperator operator) {
		this.operator=(IPolicyActionOperator)operator;
	}

}
