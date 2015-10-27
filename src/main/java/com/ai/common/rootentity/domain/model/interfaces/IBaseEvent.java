package com.ai.common.rootentity.domain.model.interfaces;

import java.util.Set;

import com.ai.common.policy.domain.model.interfaces.IPolicyCondition;

public interface IBaseEvent {
	Set<IEventSubscriberRule> getEventSubscriberRules();
	void addEventSubscriberRule(IEventSubscriberRule eventSubscriberRule);
	Set<IPolicyCondition> getConditions() ;
	 void addCondition(IPolicyCondition condition);
}
