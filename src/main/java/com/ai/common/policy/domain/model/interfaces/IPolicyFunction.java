package com.ai.common.policy.domain.model.interfaces;

import java.util.Set;

import com.ai.common.rootentity.domain.model.interfaces.IInstanceEntity;

public interface IPolicyFunction extends IInstanceEntity {
	long getId();
	void setId(long id);
	String getName();
	void setName(String name);
	String getCode();
	void setCode(String code);	
	Set<IPolicyFunctionParameter> getParameters();
	void addParameter(IPolicyFunctionParameter param);
} 
