package com.ai.common.policy.domain.model.interfaces;

import com.ai.common.rootentity.domain.model.interfaces.ISpecificationEntity;

public interface IPolicyOperator extends ISpecificationEntity {
	long getId();
	void setId(long id);
	String toBodyString(String a,String b);
}
