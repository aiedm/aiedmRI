package com.ai.crm.customerorder.domain.event.configproduct;

import com.ai.crm.customerorder.domain.model.ToBeOfferInstance;

public class NewOfferUpdated {
	private ToBeOfferInstance toBeOfferInstance;
	public ToBeOfferInstance getToBeOfferInstance() {
		return toBeOfferInstance;
	}
	public void setToBeOfferInstance(ToBeOfferInstance toBeOfferInstance) {
		this.toBeOfferInstance = toBeOfferInstance;
	}
	public NewOfferUpdated() {
	}

}
