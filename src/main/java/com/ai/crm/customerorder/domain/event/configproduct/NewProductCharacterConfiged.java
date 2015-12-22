package com.ai.crm.customerorder.domain.event.configproduct;

import com.ai.common.bpmn.model.BaseEvent;
import com.ai.crm.customerorder.domain.model.ToBeOfferInstance;
import com.ai.crm.customerorder.domain.model.ToBeProduct;

public class NewProductCharacterConfiged extends BaseEvent {
	//get and set price plan instance from offer instance
	private ToBeOfferInstance toBeOfferInstance;
	private ToBeProduct toBeProduct;
	public ToBeOfferInstance getToBeOfferInstance() {
		return toBeOfferInstance;
	}

	public void setToBeOfferInstance(ToBeOfferInstance toBeOfferInstance) {
		this.toBeOfferInstance = toBeOfferInstance;
	}

	public ToBeProduct getToBeProduct() {
		return toBeProduct;
	}

	public void setToBeProduct(ToBeProduct toBeProduct) {
		this.toBeProduct = toBeProduct;
	}
	public NewProductCharacterConfiged(Object source) {
		super(source);
	}

}
