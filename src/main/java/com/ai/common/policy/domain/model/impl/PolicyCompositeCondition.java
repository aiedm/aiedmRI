package com.ai.common.policy.domain.model.impl;

import java.util.HashSet;
import java.util.Set;

import com.ai.common.policy.domain.model.interfaces.IPolicyAction;
import com.ai.common.policy.domain.model.interfaces.IPolicyCompositeCondition;
import com.ai.common.policy.domain.model.interfaces.IPolicyCompositeConditionOption;
import com.ai.common.policy.domain.model.interfaces.IPolicyVariable;

public class PolicyCompositeCondition extends PolicyCondition implements IPolicyCompositeCondition {
	private Set<IPolicyCompositeConditionOption> children=new HashSet<IPolicyCompositeConditionOption>();
	private boolean isOr;
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
	public String toBodyString() {
		StringBuffer sb=new StringBuffer();
		Set<IPolicyCompositeConditionOption> children=this.getChildren();
		if(children.size()>0){
			sb.append("(");
			for (IPolicyCompositeConditionOption iPolicyCompositeConditionOption : children) {
				sb.append("(");
				sb.append(iPolicyCompositeConditionOption.getChildCondition().toBodyString());
				sb.append(")");
				if(this.isOr()){
					sb.append(" || ");
				}else{
					sb.append(" && ");
				}
			}
			int lastIdx=sb.lastIndexOf(" && ");
			if(lastIdx==0){
				lastIdx=sb.lastIndexOf(" || ");
			}
			if(lastIdx>0){
				sb.delete(lastIdx, sb.length());
			}
			sb.append(")");
		}
		
		return sb.toString();
	}

	@Override
	public Set<IPolicyVariable> getVariables() {
		Set<IPolicyVariable> variables=new HashSet<IPolicyVariable>();
		for (IPolicyCompositeConditionOption iPolicyCompositeConditionOption : children) {
			variables.addAll(iPolicyCompositeConditionOption.getChildCondition().getVariables());
		}
		return variables;
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
	

}
