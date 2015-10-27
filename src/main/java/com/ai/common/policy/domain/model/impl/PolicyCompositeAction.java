package com.ai.common.policy.domain.model.impl;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import com.ai.common.policy.domain.model.interfaces.IPolicyAction;
import com.ai.common.policy.domain.model.interfaces.IPolicyCompositeAction;
import com.ai.common.policy.domain.model.interfaces.IPolicyVariable;

public class PolicyCompositeAction extends PolicyAction implements IPolicyCompositeAction {
	Set<IPolicyAction> children=new LinkedHashSet<IPolicyAction>();
	public PolicyCompositeAction() {
	}

	@Override
	public String toBodyString() {
		StringBuffer sb=new StringBuffer();
		for (IPolicyAction iPolicyAction : children) {
			sb.append("            ").append(iPolicyAction.toBodyString());
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

	@Override
	public Set<IPolicyVariable> getVariables() {
		Set<IPolicyVariable> variables=new HashSet<IPolicyVariable>();
		for (IPolicyAction iPolicyAction : children) {
			variables.addAll(iPolicyAction.getVariables());
		}
		return variables;
	}

}
