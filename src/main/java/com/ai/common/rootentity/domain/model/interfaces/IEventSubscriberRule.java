package com.ai.common.rootentity.domain.model.interfaces;

import java.util.Set;

import com.ai.common.policy.domain.model.interfaces.IPolicySet;

public interface IEventSubscriberRule {
	IBaseEvent getEvent();
	void setEvent(IBaseEvent event);
	ISpecificationEntity getSubscriber();
	void setSubscriber(ISpecificationEntity subscriber);
	Set<IPolicySet> getOnEventActionRules();
	void addOnEventActionRule(IPolicySet actionRule);

}
