package com.ai.crm.customerorder.domain.model.interfaces;

import com.ai.crm.product.domain.model.interfaces.IOfferInstance;

public interface IToBeOfferInstance extends IOfferInstance {
	IOfferOrder getOfferOrder();
	void setOfferOrder(IOfferOrder offerOrder);
}
