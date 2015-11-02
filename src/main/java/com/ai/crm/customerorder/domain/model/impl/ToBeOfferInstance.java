package com.ai.crm.customerorder.domain.model.impl;

import org.springframework.stereotype.Component;

import com.ai.crm.customerorder.domain.model.interfaces.IToBeOfferInstance;
import com.ai.crm.product.domain.model.impl.OfferInstance;
import com.ai.crm.product.domain.model.interfaces.IOfferInstance;
@Component
public class ToBeOfferInstance extends OfferInstance implements IToBeOfferInstance {
	private IOfferInstance asIsOfferInstance;
	public ToBeOfferInstance() {
	}

	@Override
	public IOfferInstance getAsIsOfferInstance() {
		return asIsOfferInstance;
	}

	@Override
	public void setAsIsOfferInstance(IOfferInstance offerInstance) {
		this.asIsOfferInstance=offerInstance;
	}

}
