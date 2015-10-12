package com.ai.common.policy.domain.model.interfaces;

public interface IPolicyFunctionVariable extends IPolicyVariable {
	IPolicyFunction getFunction();
	void setFunction(IPolicyFunction function);
}
