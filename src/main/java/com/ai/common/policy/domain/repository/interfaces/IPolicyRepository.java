package com.ai.common.policy.domain.repository.interfaces;

import java.util.Set;

import com.ai.common.policy.domain.model.PolicySet;

public interface IPolicyRepository {
	Set<PolicySet> getEventRegistePolicies(String eventCode,long specificationEntityId) throws Exception;
}
