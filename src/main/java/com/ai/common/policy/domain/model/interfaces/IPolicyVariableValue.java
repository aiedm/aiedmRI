package com.ai.common.policy.domain.model.interfaces;

public interface IPolicyVariableValue extends IPolicyValue {
	IPolicyVariable getVariable();
	void setVariable(IPolicyVariable variable);
}
