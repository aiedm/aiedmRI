package com.ai.crm.product.domain.model.interfaces;

import java.util.Set;

import com.ai.common.rootentity.domain.model.interfaces.IInstanceEntity;

public interface IPricePlanInstance extends IInstanceEntity{
	long getPricePlanInstanceId();
	void setPricePlanInstanceId(long pricePlanInstanceId);
	IOfferInstance getOfferInstance();
	void setOfferInstance(IOfferInstance offerInstance);
	Set<IProduct> getAssignedTo();
	void assignTo(IProduct product);
	long getPricePlanId();
	void setPricePlanId(long pricePlanId);
}
