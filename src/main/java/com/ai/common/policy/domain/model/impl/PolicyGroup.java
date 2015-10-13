package com.ai.common.policy.domain.model.impl;

import java.util.Set;

import com.ai.common.policy.domain.model.interfaces.IPolicyGroup;
import com.ai.common.policy.domain.model.interfaces.IPolicyRule;
import com.ai.common.policy.domain.model.interfaces.IPolicySet;

public class PolicyGroup extends PolicySet implements IPolicyGroup {

	public PolicyGroup() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Set<IPolicySet> getPolicySets() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addPolicySet(IPolicySet policySet) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean hasCharacteristic() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toPolicyString() {
		StringBuffer bf=new StringBuffer();
		Set<IPolicySet> childrens=this.getPolicySets();
		for (IPolicySet iPolicySet : childrens) {
			bf.append(iPolicySet.toPolicyString());
		}
		return null;
	}

}
