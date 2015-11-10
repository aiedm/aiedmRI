package com.ai.common.policy.domain.repository.impl;

import java.util.Set;

import org.springframework.stereotype.Component;

import com.ai.common.policy.domain.model.PolicySet;
import com.ai.common.policy.domain.repository.interfaces.IPolicyRepository;
@Component
public class PolicyRepository implements IPolicyRepository {

	public PolicyRepository() {
	}

	@Override
	public Set<PolicySet> getEventRegistePolicies(String  eventCode, long specificationEntityId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
