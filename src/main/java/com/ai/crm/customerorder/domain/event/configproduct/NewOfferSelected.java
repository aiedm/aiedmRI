package com.ai.crm.customerorder.domain.event.configproduct;

import com.ai.common.rootentity.domain.model.impl.BaseEvent;
import com.ai.crm.customerorder.domain.model.interfaces.IToBeOfferInstance;

public class NewOfferSelected extends BaseEvent {
	private IToBeOfferInstance toBeOfferInstance;
	public IToBeOfferInstance getToBeOfferInstance() {
		return toBeOfferInstance;
	}
	public void setToBeOfferInstance(IToBeOfferInstance toBeOfferInstance) {
		this.toBeOfferInstance = toBeOfferInstance;
	}
	
	public NewOfferSelected(Object source) {
		super(source);
	}

}
