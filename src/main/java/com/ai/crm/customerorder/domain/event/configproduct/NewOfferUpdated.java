package com.ai.crm.customerorder.domain.event.configproduct;

import com.ai.crm.customerorder.domain.model.interfaces.IToBeOfferInstance;

public class NewOfferUpdated {
	private IToBeOfferInstance toBeOfferInstance;
	public IToBeOfferInstance getToBeOfferInstance() {
		return toBeOfferInstance;
	}
	public void setToBeOfferInstance(IToBeOfferInstance toBeOfferInstance) {
		this.toBeOfferInstance = toBeOfferInstance;
	}
	public NewOfferUpdated() {
	}

}
