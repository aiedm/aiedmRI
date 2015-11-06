package com.ai.crm.customerorder.domain.event.createorder;

import com.ai.common.rootentity.domain.model.impl.BaseEvent;
import com.ai.common.rootentity.domain.model.impl.CheckResult;
import com.ai.crm.customerorder.application.service.api.dto.OfferOrderItemDTO;

public class CheckNewOfferOrderRequested extends BaseEvent {
	private OfferOrderItemDTO offerOrderDTO;
	private CheckResult checkResult;

	public OfferOrderItemDTO getOfferOrderDTO() {
		return offerOrderDTO;
	}

	public void setOfferOrderDTO(OfferOrderItemDTO offerOrder) {
		this.offerOrderDTO = offerOrder;
	}

	public CheckNewOfferOrderRequested(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}

	public CheckResult getCheckResult() {
		return checkResult;
	}

	public void setCheckResult(CheckResult checkResult) {
		this.checkResult = checkResult;
	}

}
