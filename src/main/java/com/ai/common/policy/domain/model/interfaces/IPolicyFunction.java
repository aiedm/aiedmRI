package com.ai.common.policy.domain.model.interfaces;

import java.util.Set;

import com.ai.common.rootentity.domain.model.interfaces.ISpecificationEntity;

public interface IPolicyFunction extends ISpecificationEntity {
	Set<IPolicyFunctionParameter> getParameters();
	void addParameter(IPolicyFunctionParameter param);
} 
