package com.ai.common.policy.domain.model.interfaces;

public interface IPolicyAtomicCondition extends IPolicyCondition {
	IPolicyConditionStatement getStatement();
	void setStatement(IPolicyConditionStatement statement);
}
