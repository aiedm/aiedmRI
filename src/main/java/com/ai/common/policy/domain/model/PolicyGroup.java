package com.ai.common.policy.domain.model;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
@Entity
public class PolicyGroup extends PolicySet{
	@OneToMany(mappedBy="parentPolicySet",fetch=FetchType.LAZY)
	private Set<PolicySet> policySets=new LinkedHashSet<PolicySet>();
	@OneToMany(mappedBy="policyRule",fetch=FetchType.LAZY,targetEntity=PolicyRuleParameter.class)
	private Set<PolicyRuleInputParameter> inputParameters=new LinkedHashSet<PolicyRuleInputParameter>();
	public PolicyGroup() {
	}

	
	public Set<PolicySet> getPolicySets() {
		return this.policySets;
	}

	
	public void addPolicySet(PolicySet policySet) {
		if (null!=policySet){
			policySets.add(policySet);
		}
	}

	
	public String toBodyString() {
		StringBuffer bf=new StringBuffer();
		Set<PolicySet> childrens=this.getPolicySets();
		if (childrens.size()>0) {			
			for (PolicySet PolicySet : childrens) {
				if(null!=this.getElseAction()||this.isEnableElseAction==false){
					PolicySet.disableElseAction();
				}
				bf.append(PolicySet.toBodyString());
			}			
		}
		return bf.toString();
	}

	
	public Set<PolicyRuleInputParameter> getInputParameters() {
		Set<PolicySet> children=this.getPolicySets();
		for (PolicySet PolicySet : children) {
			this.inputParameters.addAll(PolicySet.getInputParameters());
		}
		return this.inputParameters;
	}

	
	
	public Map<String,PolicyVariable> getVariableMap(){
		Map<String , PolicyVariable>  map=new HashMap<String, PolicyVariable>();
		Set<PolicySet> children=this.getPolicySets();
		for (PolicySet PolicySet : children) {
			map.putAll(PolicySet.getVariableMap());
		}	
		return map;
	}

}
