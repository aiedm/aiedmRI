package com.ai.common.policy.domain.model.interfaces;

import com.ai.common.rootentity.domain.model.interfaces.ISpecificationEntity;

public interface IPolicyFunctionParameter extends ISpecificationEntity {
	IPolicyFunction getFunction();
	void setFunction(IPolicyFunction function);
	Object getParameterType();
	void setarameterType(Object param);
}
