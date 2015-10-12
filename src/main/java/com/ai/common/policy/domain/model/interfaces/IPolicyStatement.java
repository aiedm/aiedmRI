package com.ai.common.policy.domain.model.interfaces;

import com.ai.common.rootentity.domain.model.interfaces.IInstanceEntity;

public interface IPolicyStatement extends IInstanceEntity {
	IPolicyVariable getVariable();
	void setVariable(IPolicyVariable varible);
	IPolicyOperator getOperator();
	void setOperator(IPolicyOperator Operator);
	IPolicyValue getValue();
	void setValue(IPolicyValue value);
}
