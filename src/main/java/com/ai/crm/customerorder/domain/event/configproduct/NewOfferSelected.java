package com.ai.crm.customerorder.domain.event.configproduct;

import com.ai.common.bpmn.model.BaseEvent;
import com.ai.crm.customerorder.domain.model.ToBeOfferInstance;

public class NewOfferSelected extends BaseEvent {
	private ToBeOfferInstance toBeOfferInstance;
	public ToBeOfferInstance getToBeOfferInstance() {
		return toBeOfferInstance;
	}
	public void setToBeOfferInstance(ToBeOfferInstance toBeOfferInstance) {
		this.toBeOfferInstance = toBeOfferInstance;
	}
	
	public NewOfferSelected(Object source) {
		super(source);
	}

}
