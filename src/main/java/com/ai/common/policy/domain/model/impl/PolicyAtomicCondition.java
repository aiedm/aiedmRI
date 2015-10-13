package com.ai.common.policy.domain.model.impl;

import com.ai.common.policy.domain.model.interfaces.IPolicyAtomicCondition;
import com.ai.common.policy.domain.model.interfaces.IPolicyStatement;

public class PolicyAtomicCondition extends PolicyCondition implements IPolicyAtomicCondition {

	public PolicyAtomicCondition() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public IPolicyStatement getStatement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setStatement(IPolicyStatement statement) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean hasCharacteristic() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toPolicyString() {
		return "("+this.getStatement().toPolicyString()+")";
	}
}
