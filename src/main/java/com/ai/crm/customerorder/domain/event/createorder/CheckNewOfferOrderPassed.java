package com.ai.crm.customerorder.domain.event.createorder;

import com.ai.common.bpmn.model.BaseEvent;
import com.ai.crm.customerorder.application.service.api.dto.OfferOrderItemDTO;

public class CheckNewOfferOrderPassed extends BaseEvent {
	private OfferOrderItemDTO offerOrderDTO;
	public OfferOrderItemDTO getOfferOrderDTO() {
		return offerOrderDTO;
	}
	public void setOfferOrderDTO(OfferOrderItemDTO offerOrder) {
		this.offerOrderDTO = offerOrder;
	}
	public CheckNewOfferOrderPassed(Object source) {
		super(source);
	}

}
