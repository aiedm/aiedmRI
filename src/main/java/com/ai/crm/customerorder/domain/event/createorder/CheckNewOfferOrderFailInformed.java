package com.ai.crm.customerorder.domain.event.createorder;

import com.ai.common.rootentity.domain.model.BaseEvent;
import com.ai.crm.customerorder.application.service.api.dto.OfferOrderItemDTO;

public class CheckNewOfferOrderFailInformed extends BaseEvent {
	private OfferOrderItemDTO offerOrderDTO;
	public OfferOrderItemDTO getOfferOrderDTO() {
		return offerOrderDTO;
	}
	public void setOfferOrderDTO(OfferOrderItemDTO offerOrder) {
		this.offerOrderDTO = offerOrder;
	}
	public CheckNewOfferOrderFailInformed(Object source) {
		super(source);
	}

}
