package com.ai.common.policy.domain.model.impl;

import com.ai.common.policy.domain.model.interfaces.IPolicyCompositeCondition;
import com.ai.common.policy.domain.model.interfaces.IPolicyCompositeConditionOption;
import com.ai.common.policy.domain.model.interfaces.IPolicyCondition;
import com.ai.common.rootentity.domain.model.impl.InstanceEntity;

public class PolicyCompositeConditionOption extends InstanceEntity implements IPolicyCompositeConditionOption {
	private IPolicyCompositeCondition parent;
	private IPolicyCondition child;
	private boolean isOr;
	
	public PolicyCompositeConditionOption() {
	}

	@Override
	public IPolicyCondition getChildCondition() {
		return this.child;
	}

	@Override
	public void setChildCondition(IPolicyCondition child) {
		this.child=child;
	}

	@Override
	public boolean isOr() {
		return this.isOr;
	}

	@Override
	public void setOr() {
		this.isOr=true;
	}

	@Override
	public void setAnd() {
		this.isOr=false;
	}

	@Override
	public boolean hasCharacteristic() {
		return false;
	}

	@Override
	public IPolicyCompositeCondition getParentCondition() {
		return this.parent;
	}

	@Override
	public void setParentCondition(IPolicyCompositeCondition parent) {
		this.parent=parent;
	}

}
