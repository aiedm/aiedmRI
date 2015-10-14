package com.ai.common.policy.domain.model.impl;

import com.ai.common.policy.domain.model.interfaces.IPolicyAction;
import com.ai.common.policy.domain.model.interfaces.IPolicyCondition;
import com.ai.common.policy.domain.model.interfaces.IPolicyRule;

public class PolicyRule extends PolicySet implements IPolicyRule {
	private boolean isElseAction;
	private IPolicyCondition condition;
	private IPolicyAction action;
	public PolicyRule() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public IPolicyCondition getCondition() {
		return this.condition;
	}

	@Override
	public void setCondition(IPolicyCondition condition) {
		this.condition=condition;
	}

	@Override
	public IPolicyAction getAction() {
		return this.action;
	}

	@Override
	public void getAction(IPolicyAction action) {
		this.action=action;
	}

	@Override
	public boolean isElseAction() {
		return this.isElseAction;
	}

	@Override
	public String toPolicyString() {
		StringBuffer bf=new StringBuffer();
		if (this.isElseAction()){
			bf.append(this.getAction().toPolicyString()).append(";\n");
		}else{
			bf.append("if ").append(this.getCondition().toPolicyString()).append("{\n")
			.append("    ").append(this.getAction().toPolicyString()).append(";\n")
			.append("}\n");			
		}		
		return bf.toString();
	}

	@Override
	public void setElseAction(boolean isElseAction) {
		this.isElseAction=isElseAction;		
	}

}
