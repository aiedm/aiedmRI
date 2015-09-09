package com.ai.crm.customerorder.domain.model.impl;

import com.ai.crm.customerorder.domain.model.interfaces.IOfferOrder;
import com.ai.crm.customerorder.domain.model.interfaces.IToBeOfferInstance;
import com.ai.crm.product.domain.model.impl.OfferInstance;

public class ToBeOfferInstance extends OfferInstance implements IToBeOfferInstance {

	public ToBeOfferInstance() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public IOfferOrder getOfferOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setOfferOrder(IOfferOrder offerOrder) {
		// TODO Auto-generated method stub

	}

}
