package com.ai.crm.customerorder.domain.model.interfaces;

import com.ai.crm.product.domain.model.interfaces.IOfferInstance;

public interface IToBeOfferInstance extends IOfferInstance {
	IOfferInstance getAsIsOfferInstance();
	void setAsIsOfferInstance(IOfferInstance offerInstance);
}
