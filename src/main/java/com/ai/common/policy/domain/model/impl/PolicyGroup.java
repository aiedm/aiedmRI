package com.ai.common.policy.domain.model.impl;

import java.util.HashSet;
import java.util.Set;

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
			bf.append("boolean matched=false;\n");
			for (IPolicySet iPolicySet : childrens) {
				if(iPolicySet instanceof IPolicyRule){
					if (((IPolicyRule)iPolicySet).isElseAction()){
						bf.append("if (matched==false) {\n")
						.append("    ").append(iPolicySet.toBodyString()).append(";\n")
						.append("}\n");
					}else{
						bf.append("if (matched==false) {\n")
						.append(" ").append("matched=true\n;")
						.append(" }\n")
						.append(iPolicySet.toBodyString());
					}
				}else{
					bf.append(iPolicySet.toBodyString());
				}
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

}
