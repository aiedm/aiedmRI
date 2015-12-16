package com.ai.common.policy.domain.model;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
@Entity
@DiscriminatorValue("COMPOSITE")
public class PolicyCompositeAction extends PolicyAction{
	@OneToMany(mappedBy="parentAction",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	Set<PolicyAction> children=new LinkedHashSet<PolicyAction>();
	public PolicyCompositeAction(PolicySet policyset) {
		super(policyset);
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
			child.setParentAction(this);
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
