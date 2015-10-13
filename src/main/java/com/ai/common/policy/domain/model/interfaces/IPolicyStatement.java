package com.ai.common.policy.domain.model.interfaces;

import com.ai.common.rootentity.domain.model.interfaces.IInstanceEntity;

public interface IPolicyStatement extends IInstanceEntity {
	long getId();
	void setId(long id);
	String getName();
	void setName(String name);
	String getCode();
	void setCode(String code);	
	IPolicyVariable getVariable();
	void setVariable(IPolicyVariable varible);
	IPolicyOperator getOperator();
	void setOperator(IPolicyOperator Operator);
	IPolicyValue getValue();
	void setValue(IPolicyValue value);
	String toPolicyString();
}
