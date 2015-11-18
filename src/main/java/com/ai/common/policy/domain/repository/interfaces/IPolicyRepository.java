package com.ai.common.policy.domain.repository.interfaces;

import java.util.Set;

import com.ai.common.rootentity.domain.model.EventSubscriber;

public interface IPolicyRepository {
	Set<EventSubscriber> getEventRegistePolicies(String eventCode,long specificationEntityId) throws Exception;
}
