package com.ai.common.policy.domain.model.interfaces;

import com.ai.common.rootentity.domain.model.interfaces.IInstanceEntity;

public interface IPolicyCompositeConditionOption extends IInstanceEntity {
	IPolicyCompositeCondition getParentCondition();
	void setParentCondition(IPolicyCompositeCondition parent);
	IPolicyCondition getChildCondition();
	void setChildCondition(IPolicyCondition child);
	boolean isOr();
	void setOr();
	void setAnd();
}
