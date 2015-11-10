package com.ai.crm.customerorder.domain.event.configproduct;

import com.ai.common.rootentity.domain.model.BaseEvent;
import com.ai.crm.customerorder.domain.model.ToBeOfferInstance;
import com.ai.crm.customerorder.domain.model.ToBeProduct;

public class NewProductSelected extends BaseEvent {
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
	
	public NewProductSelected(Object source) {
		super(source);
	}

}
