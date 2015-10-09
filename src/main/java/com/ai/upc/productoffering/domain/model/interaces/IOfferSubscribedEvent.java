package com.ai.upc.productoffering.domain.model.interaces;

import java.util.Set;

import com.ai.common.policy.domain.model.interfaces.IPolicySet;
import com.ai.common.rootentity.interfaces.ISpecificationEntity;
import com.ai.flyingshuttle.base.BaseEvent;

public interface IOfferSubscribedEvent extends ISpecificationEntity {
	IProductOffering getOffer();
	void setOffer(IProductOffering offer);
	BaseEvent getEvent();
	void setEvent(BaseEvent event);
	Set<IPolicySet> getPolicies();
	void addPolicy(IPolicySet policySet);
}
