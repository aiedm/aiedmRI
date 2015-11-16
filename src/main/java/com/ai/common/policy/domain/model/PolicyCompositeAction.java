package com.ai.common.policy.domain.model;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.FetchType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
@MappedSuperclass
public class PolicyCompositeAction extends PolicyAction{
	@OneToMany(mappedBy="parentAction",fetch=FetchType.LAZY)
	Set<PolicyAction> children=new LinkedHashSet<PolicyAction>();
	public PolicyCompositeAction() {
	}

	
	public String toBodyString() {
		StringBuffer sb=new StringBuffer();
		for (PolicyAction PolicyAction : children) {
			sb.append("            ").append(PolicyAction.toBodyString());
		}
		return sb.toString();
	}

	
	public Set<PolicyAction> getChildren() {
		return this.children;
	}

	
	public void addChild(PolicyAction child) {
		if (null!=child){
			this.children.add(child);			
		}		
	}

	
	public Set<PolicyVariable> getVariables() {
		Set<PolicyVariable> variables=new HashSet<PolicyVariable>();
		for (PolicyAction PolicyAction : children) {
			variables.addAll(PolicyAction.getVariables());
		}
		return variables;
	}

}
