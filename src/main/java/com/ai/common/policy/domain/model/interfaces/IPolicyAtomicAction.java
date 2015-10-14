package com.ai.common.policy.domain.model.interfaces;

public interface IPolicyAtomicAction extends IPolicyAction {
	IPolicyActionStatement getStatement();
	void setStatement(IPolicyActionStatement statement);
}
