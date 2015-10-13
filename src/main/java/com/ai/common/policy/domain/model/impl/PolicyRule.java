package com.ai.common.policy.domain.model.impl;

import com.ai.common.policy.domain.model.interfaces.IPolicyAction;
import com.ai.common.policy.domain.model.interfaces.IPolicyCondition;
import com.ai.common.policy.domain.model.interfaces.IPolicyFunction;
import com.ai.common.policy.domain.model.interfaces.IPolicyRule;

public class PolicyRule extends PolicySet implements IPolicyRule {

	public PolicyRule() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public IPolicyCondition getCondition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCondition(IPolicyCondition condition) {
		// TODO Auto-generated method stub

	}

	@Override
	public IPolicyAction getAction() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getAction(IPolicyAction action) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isElseAction() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasCharacteristic() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toPolicyString() {
		StringBuffer bf=new StringBuffer();
		IPolicyCondition condition=this.getCondition();
		
		// TODO Auto-generated method stub
		return null;
	}

}
