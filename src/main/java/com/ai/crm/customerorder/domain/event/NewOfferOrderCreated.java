package com.ai.crm.customerorder.domain.event;

import com.ai.crm.customerorder.domain.model.interfaces.IOfferOrderItem;
import com.ai.flyingshuttle.base.BaseEvent;

public class NewOfferOrderCreated extends BaseEvent {
	private IOfferOrderItem offerOrder;

	public IOfferOrderItem getOfferOrder() {
		return offerOrder;
	}

	public void setOfferOrder(IOfferOrderItem offerOrder) {
		this.offerOrder = offerOrder;
	}
	public NewOfferOrderCreated(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}

}
