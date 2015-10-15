package com.ai.common.policy.domain.model.impl;

import java.util.HashSet;
import java.util.Set;

import com.ai.common.policy.domain.model.interfaces.IPolicyAtomicCondition;
import com.ai.common.policy.domain.model.interfaces.IPolicyConditionStatement;
import com.ai.common.policy.domain.model.interfaces.IPolicyVariable;

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
	public String toBodyString() {
		return this.getStatement().toBodyString();
	}

	@Override
	public Set<IPolicyVariable> getVariables() {
		Set<IPolicyVariable> variables=new HashSet<IPolicyVariable>();
		variables.add(this.getStatement().getVariable());
		return variables;
	}
}
