package com.ai.crm.customerorder.domain.event;

import com.ai.crm.customerorder.domain.model.interfaces.IOfferOrder;
import com.ai.flyingshuttle.base.BaseEvent;

public class NewOfferOrderCreated extends BaseEvent {
	private IOfferOrder offerOrder;

	public IOfferOrder getOfferOrder() {
		return offerOrder;
	}

	public void setOfferOrder(IOfferOrder offerOrder) {
		this.offerOrder = offerOrder;
	}
	public NewOfferOrderCreated(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}

}
