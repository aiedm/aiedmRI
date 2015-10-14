package com.ai.common.policy.domain.model.impl;

import com.ai.common.policy.domain.model.interfaces.IPolicyConditionOperator;
import com.ai.common.policy.domain.model.interfaces.IPolicyConditionStatement;
import com.ai.common.policy.domain.model.interfaces.IPolicyOperator;

public class PolicyConditionStatement extends PolicyStatement implements IPolicyConditionStatement {
	private IPolicyConditionOperator operator;
	public PolicyConditionStatement() {
	}

	@Override
	public IPolicyOperator getOperator() {
		return this.operator;
	}

	@Override
	public void setOperator(IPolicyOperator operator) {
		this.operator=(IPolicyConditionOperator)operator;
	}

}
