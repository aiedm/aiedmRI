package com.ai.common.policy.domain.model.interfaces;

import com.ai.common.rootentity.domain.model.interfaces.IInstanceEntity;

public interface IPolicySetParameter extends IInstanceEntity {
	long getId();
	void setId(long id);
	String getName();
	void setName(String name);
	String getCode();
	void setCode(String code);	
	IPolicySet getPolicySet();
	void setPolicySet(IPolicySet policySet);
	String getParameterType();
	void setarameterType(String paramType);
}
