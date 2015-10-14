package com.ai.common.policy.domain.model.impl;

import java.util.HashSet;
import java.util.Set;

import com.ai.common.policy.domain.model.interfaces.IPolicyAction;
import com.ai.common.policy.domain.model.interfaces.IPolicyCompositeAction;

public class PolicyCompositeAction extends PolicyAction implements IPolicyCompositeAction {
	Set<IPolicyAction> children=new HashSet<IPolicyAction>();
	public PolicyCompositeAction() {
	}

	@Override
	public String toPolicyString() {
		StringBuffer sb=new StringBuffer();
		for (IPolicyAction iPolicyAction : children) {
			sb.append(iPolicyAction.toPolicyString());
		}
		return sb.toString();
	}

	@Override
	public Set<IPolicyAction> getChildren() {
		return this.children;
	}

	@Override
	public void addChild(IPolicyAction child) {
		if (null!=child){
			this.children.add(child);			
		}		
	}

}
