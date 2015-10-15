package com.ai.common.policy.domain.model.interfaces;

import com.ai.common.rootentity.domain.model.interfaces.IInstanceEntity;

public interface IPolicySetParameter extends IInstanceEntity {
	long getId();
	void setId(long id);
	IPolicyVariable getVariable();
	void setVariable(IPolicyVariable variable);	
	IPolicySet getPolicySet();
	void setPolicySet(IPolicySet policySet);
}
