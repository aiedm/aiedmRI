package com.ai.crm.customerorder.domain.event.configproduct;

import com.ai.common.rootentity.domain.model.BaseEvent;
import com.ai.crm.customerorder.domain.model.ToBeOfferInstance;

public class NewOfferCharacterConfiged extends BaseEvent {
	private ToBeOfferInstance toBeOfferInstance;
	public ToBeOfferInstance getToBeOfferInstance() {
		return toBeOfferInstance;
	}
	public void setToBeOfferInstance(ToBeOfferInstance toBeOfferInstance) {
		this.toBeOfferInstance = toBeOfferInstance;
	}
	public NewOfferCharacterConfiged(Object source) {
		super(source);
	}

}
