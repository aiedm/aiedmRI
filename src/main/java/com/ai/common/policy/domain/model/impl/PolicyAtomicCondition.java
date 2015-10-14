package com.ai.common.policy.domain.model.impl;

import com.ai.common.policy.domain.model.interfaces.IPolicyAtomicCondition;
import com.ai.common.policy.domain.model.interfaces.IPolicyConditionStatement;

public class PolicyAtomicCondition extends PolicyCondition implements IPolicyAtomicCondition {
	private IPolicyConditionStatement statement;
	public PolicyAtomicCondition() {
	}

	@Override
	public IPolicyConditionStatement getStatement() {
		return this.statement;
	}

	@Override
	public void setStatement(IPolicyConditionStatement statement) {
		this.statement=statement;
	}

	@Override
	public boolean hasCharacteristic() {
		return false;
	}

	@Override
	public String toPolicyString() {
		return "("+this.getStatement().toPolicyString()+")";
	}
}
