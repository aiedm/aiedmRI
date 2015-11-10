package com.ai.crm.customerorder.domain.event.createorder;

import com.ai.common.rootentity.domain.model.BaseEvent;
import com.ai.crm.customerorder.domain.model.OfferOrderItem;

public class NewOfferOrderCreated extends BaseEvent {
	private OfferOrderItem offerOrder;

	public OfferOrderItem getOfferOrder() {
		return offerOrder;
	}

	public void setOfferOrder(OfferOrderItem offerOrder) {
		this.offerOrder = offerOrder;
	}
	public NewOfferOrderCreated(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}

}
