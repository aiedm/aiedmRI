package com.ai.common.policy.domain.repository.impl;

import java.util.Set;

import com.ai.common.policy.domain.model.interfaces.IPolicySet;
import com.ai.common.policy.domain.repository.interfaces.IPolicyRepository;

public class PolicyRepository implements IPolicyRepository {

	public PolicyRepository() {
	}

	@Override
	public Set<IPolicySet> getEventRegistePolicies(String  eventCode, long specificationEntityId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
