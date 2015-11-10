package com.ai.common.policy.domain.model;

import com.ai.common.rootentity.domain.model.InstanceEntity;

public class PolicyCompositeConditionOption extends InstanceEntity {
	private PolicyCompositeCondition parent;
	private PolicyCondition child;
	
	public PolicyCompositeConditionOption() {
	}

	
	public PolicyCondition getChildCondition() {
		return this.child;
	}

	
	public void setChildCondition(PolicyCondition child) {
		this.child=child;
	}

	
	public PolicyCompositeCondition getParentCondition() {
		return this.parent;
	}

	
	public void setParentCondition(PolicyCompositeCondition parent) {
		this.parent=parent;
	}

}
