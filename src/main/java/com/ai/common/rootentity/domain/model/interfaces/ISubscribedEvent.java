package com.ai.common.rootentity.domain.model.interfaces;

import java.util.Set;

import com.ai.common.policy.domain.model.interfaces.IPolicySet;
import com.ai.common.rootentity.domain.model.impl.BaseEvent;

public interface ISubscribedEvent extends ISpecificationEntity {
	ISpecificationEntity getOwner();
	void setOwner(ISpecificationEntity instanceEntity);
	BaseEvent getEvent();
	void setEvent(BaseEvent event);
	Set<IPolicySet> getPolicies();
	void addPolicy(IPolicySet policySet);
}
