package com.ai.common.policy.domain.model.impl;

import java.util.HashSet;
import java.util.Set;

import com.ai.common.policy.domain.model.interfaces.IPolicyGroup;
import com.ai.common.policy.domain.model.interfaces.IPolicyRule;
import com.ai.common.policy.domain.model.interfaces.IPolicySet;

public class PolicyGroup extends PolicySet implements IPolicyGroup {
	private Set<IPolicySet> policySets=new HashSet<IPolicySet>();

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
	public String toPolicyString() {
		StringBuffer bf=new StringBuffer();
		Set<IPolicySet> childrens=this.getPolicySets();
		if (childrens.size()>0) {
			bf.append("boolean matched=false;\n");
			for (IPolicySet iPolicySet : childrens) {
				if(iPolicySet instanceof IPolicyRule){
					if (((IPolicyRule)iPolicySet).isElseAction()){
						bf.append("if (matched==false) {\n")
						.append("    ").append(iPolicySet.toPolicyString()).append(";\n")
						.append("}\n");
					}else{
						bf.append("if (matched==false) {\n")
						.append(" ").append("matched=true\n;")
						.append(" }\n")
						.append(iPolicySet.toPolicyString());
					}
				}else{
					bf.append(iPolicySet.toPolicyString());
				}
			}			
		}
		return bf.toString();
	}

}
