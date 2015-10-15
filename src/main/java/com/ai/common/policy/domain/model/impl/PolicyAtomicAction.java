package com.ai.common.policy.domain.model.impl;

import java.util.HashSet;
import java.util.Set;

import com.ai.common.policy.domain.model.interfaces.IPolicyActionStatement;
import com.ai.common.policy.domain.model.interfaces.IPolicyAtomicAction;
import com.ai.common.policy.domain.model.interfaces.IPolicyVariable;

public class PolicyAtomicAction extends PolicyAction implements IPolicyAtomicAction {
	private IPolicyActionStatement statement;
	public PolicyAtomicAction() {
	}

	@Override
	public String toBodyString() {
		return this.getStatement().toBodyString()+";\n";
	}

	@Override
	public IPolicyActionStatement getStatement() {
		return this.statement;
	}

	@Override
	public void setStatement(IPolicyActionStatement statement) {
		this.statement=statement;
	}

	@Override
	public Set<IPolicyVariable> getVariables() {
		Set<IPolicyVariable> variables=new HashSet<IPolicyVariable>();
		variables.add(this.getStatement().getVariable());
		return variables;
	}

}
