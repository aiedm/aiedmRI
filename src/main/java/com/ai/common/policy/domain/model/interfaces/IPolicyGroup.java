package com.ai.common.policy.domain.model.interfaces;

import java.util.Set;

public interface IPolicyGroup extends IPolicySet {
	Set<IPolicySet> getPolicySets();
	void addPolicySet(IPolicySet policySet);
}
