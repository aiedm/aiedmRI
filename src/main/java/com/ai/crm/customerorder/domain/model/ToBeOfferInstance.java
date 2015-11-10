package com.ai.crm.customerorder.domain.model;

import org.springframework.stereotype.Component;

import com.ai.crm.product.domain.model.OfferInstance;
@Component
public class ToBeOfferInstance extends OfferInstance{
	private OfferInstance asIsOfferInstance;
	public ToBeOfferInstance() {
	}

	public OfferInstance getAsIsOfferInstance() {
		return asIsOfferInstance;
	}

	public void setAsIsOfferInstance(OfferInstance offerInstance) {
		this.asIsOfferInstance=offerInstance;
	}

}
