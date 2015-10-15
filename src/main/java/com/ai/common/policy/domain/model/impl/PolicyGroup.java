package com.ai.common.policy.domain.model.impl;

import java.util.HashSet;
import java.util.Set;

import com.ai.common.policy.domain.model.interfaces.IPolicyAction;
import com.ai.common.policy.domain.model.interfaces.IPolicyGroup;
import com.ai.common.policy.domain.model.interfaces.IPolicyRule;
import com.ai.common.policy.domain.model.interfaces.IPolicySet;
import com.ai.common.policy.domain.model.interfaces.IPolicySetInputParameter;
import com.ai.common.policy.domain.model.interfaces.IPolicySetOutputParameter;

public class PolicyGroup extends PolicySet implements IPolicyGroup {
	private Set<IPolicySet> policySets=new HashSet<IPolicySet>();
	private Set<IPolicySetInputParameter> inputParameters=new HashSet<IPolicySetInputParameter>();
	public PolicyGroup() {
	}

	@Override
	public Set<IPolicySet> getPolicySets() {
		return this.policySets;
	}

	@Override
	public void addPolicySet(IPolicySet policySet) {
		if (null!=policySet){
			policySets.add(policySet);
		}
	}

	@Override
	public String toBodyString() {
		StringBuffer bf=new StringBuffer();
		Set<IPolicySet> childrens=this.getPolicySets();
		if (childrens.size()>0) {			
			for (IPolicySet iPolicySet : childrens) {
				bf.append(iPolicySet.toBodyString());
			}			
		}
		return bf.toString();
	}

	@Override
	public Set<IPolicySetInputParameter> getInputParameters() {
		Set<IPolicySet> children=this.getPolicySets();
		for (IPolicySet iPolicySet : children) {
			this.inputParameters.addAll(iPolicySet.getInputParameters());
		}
		return this.inputParameters;
	}

	@Override
	public String getVariableDeclareString() {
		StringBuffer sb=new StringBuffer();
		Set<IPolicySet> children=this.getPolicySets();
		for (IPolicySet iPolicySet : children) {
			sb.append(iPolicySet.getVariableDeclareString());
		}		
		return sb.toString();
	}

}
