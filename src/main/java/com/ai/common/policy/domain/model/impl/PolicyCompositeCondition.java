package com.ai.common.policy.domain.model.impl;

import java.util.HashSet;
import java.util.Set;

import com.ai.common.policy.domain.model.interfaces.IPolicyCompositeCondition;
import com.ai.common.policy.domain.model.interfaces.IPolicyCompositeConditionOption;

public class PolicyCompositeCondition extends PolicyCondition implements IPolicyCompositeCondition {
	private Set<IPolicyCompositeConditionOption> children=new HashSet<IPolicyCompositeConditionOption>();
	public PolicyCompositeCondition() {
	}

	@Override
	public Set<IPolicyCompositeConditionOption> getChildren() {
		return this.children;
	}

	@Override
	public void addChild(IPolicyCompositeConditionOption child) {
		if(child!=null){
			this.children.add(child);
			if (null==child.getParentCondition()){
				child.setParentCondition(this);
			}
		}

	}

	@Override
	public String toPolicyString() {
		StringBuffer sb=new StringBuffer();
		Set<IPolicyCompositeConditionOption> children=this.getChildren();
		for (IPolicyCompositeConditionOption iPolicyCompositeConditionOption : children) {
			sb.append("(");
			sb.append(iPolicyCompositeConditionOption.getChildCondition().toPolicyString());
			sb.append(")");
			if(iPolicyCompositeConditionOption.isOr()){
				sb.append(" or ");
			}else{
				sb.append(" and ");
			}
		}
		return sb.toString();
	}

}
