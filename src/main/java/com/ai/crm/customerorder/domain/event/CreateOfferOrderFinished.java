package com.ai.crm.customerorder.domain.event;

import com.ai.common.rootentity.domain.model.interfaces.BaseEvent;
import com.ai.crm.customerorder.domain.model.interfaces.IOfferOrderItem;

public class CreateOfferOrderFinished extends BaseEvent {
	private IOfferOrderItem offerOrder;
	public IOfferOrderItem getOfferOrder() {
		return offerOrder;
	}
	public void setOfferOrder(IOfferOrderItem offerOrder) {
		this.offerOrder = offerOrder;
	}
	public CreateOfferOrderFinished(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}

}
