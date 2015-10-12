package com.ai.common.policy.domain.model.interfaces;

public interface IPolicyAtomicCondition extends IPolicyCondition {
	IPolicyStatement getStatement();
	void setStatement(IPolicyStatement statement);
}
