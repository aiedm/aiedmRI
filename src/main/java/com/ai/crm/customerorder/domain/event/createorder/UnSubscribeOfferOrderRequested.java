package com.ai.crm.customerorder.domain.event.createorder;

import com.ai.common.bpmn.model.BaseEvent;
import com.ai.crm.customerorder.domain.model.OfferOrderItem;

public class UnSubscribeOfferOrderRequested extends BaseEvent {
	private OfferOrderItem offerOrder;

	public OfferOrderItem getOfferOrder() {
		return offerOrder;
	}

	public void setOfferOrder(OfferOrderItem offerOrder) {
		this.offerOrder = offerOrder;
	}
	public UnSubscribeOfferOrderRequested(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}

}
