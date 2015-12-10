package com.ai.common.policy.domain.repository.interfaces;

import java.util.Set;

import com.ai.common.policy.domain.model.PolicyFunction;
import com.ai.common.policy.domain.model.PolicyOperator;
import com.ai.common.policy.domain.model.PolicySet;
import com.ai.common.rootentity.domain.model.EventSubscriber;

public interface IPolicyRepository {
	Set<EventSubscriber> getEventRegistePolicies(String eventCode,long specificationEntityId) throws Exception;
	PolicySet savePolicySet(PolicySet policySet) throws Exception;
	PolicyOperator savePolicyOperator(PolicyOperator operator) throws Exception;
	PolicyFunction savePolicyFunction(PolicyFunction function) throws Exception;
}
