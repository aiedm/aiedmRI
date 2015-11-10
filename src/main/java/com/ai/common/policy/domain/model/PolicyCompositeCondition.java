package com.ai.common.policy.domain.model;

import java.util.HashSet;
import java.util.Set;

public class PolicyCompositeCondition extends PolicyCondition{
	private Set<PolicyCompositeConditionOption> children=new HashSet<PolicyCompositeConditionOption>();
	private boolean isOr;
	public PolicyCompositeCondition() {
	}

	
	public Set<PolicyCompositeConditionOption> getChildren() {
		return this.children;
	}

	
	public void addChild(PolicyCompositeConditionOption child) {
		if(child!=null){
			this.children.add(child);
			if (null==child.getParentCondition()){
				child.setParentCondition(this);
			}
		}

	}

	
	public String toBodyString() {
		StringBuffer sb=new StringBuffer();
		Set<PolicyCompositeConditionOption> children=this.getChildren();
		if(children.size()>0){
			for (PolicyCompositeConditionOption PolicyCompositeConditionOption : children) {
				sb.append("(");
				sb.append(PolicyCompositeConditionOption.getChildCondition().toBodyString());
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
		}
		
		return sb.toString();
	}

	
	public Set<PolicyVariable> getVariables() {
		Set<PolicyVariable> variables=new HashSet<PolicyVariable>();
		for (PolicyCompositeConditionOption PolicyCompositeConditionOption : children) {
			variables.addAll(PolicyCompositeConditionOption.getChildCondition().getVariables());
		}
		return variables;
	}
	
	
	public boolean isOr() {
		return this.isOr;
	}

	
	public void setOr() {
		this.isOr=true;
	}

	
	public void setAnd() {
		this.isOr=false;
	}
	

}
