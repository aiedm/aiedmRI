package com.ai.common.policy.domain.model.impl;

import com.ai.common.policy.domain.model.interfaces.IPolicyActionStatement;
import com.ai.common.policy.domain.model.interfaces.IPolicyAtomicAction;

public class PolicyAtomicAction extends PolicyAction implements IPolicyAtomicAction {
	private IPolicyActionStatement statement;
	public PolicyAtomicAction() {
	}

	@Override
	public String toPolicyString() {
		return this.getStatement().toPolicyString()+"\n";
	}

	@Override
	public IPolicyActionStatement getStatement() {
		return this.statement;
	}

	@Override
	public void setStatement(IPolicyActionStatement statement) {
		this.statement=statement;
	}

}
