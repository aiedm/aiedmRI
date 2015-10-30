package com.ai.common.policy.domain.repository.interfaces;

import java.util.Set;

import com.ai.common.policy.domain.model.interfaces.IPolicySet;

public interface IPolicyRepository {
	Set<IPolicySet> getEventRegistePolicies(String eventCode,long specificationEntityId) throws Exception;
}
