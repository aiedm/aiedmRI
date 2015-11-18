package com.ai.common.policy.domain.repository.impl;

import java.util.Set;

import org.springframework.stereotype.Component;
import com.ai.common.policy.domain.repository.interfaces.IPolicyRepository;
import com.ai.common.rootentity.domain.model.EventSubscriber;
@Component
public class PolicyRepository implements IPolicyRepository {

	public PolicyRepository() {
	}
	
	@Override
	public Set<EventSubscriber> getEventRegistePolicies(String  eventCode, long specificationEntityId) throws Exception {
		
		return null;
	}


}
