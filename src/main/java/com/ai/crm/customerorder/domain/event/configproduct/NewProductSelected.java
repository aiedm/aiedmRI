package com.ai.crm.customerorder.domain.event.configproduct;

import com.ai.common.rootentity.domain.model.impl.BaseEvent;
import com.ai.crm.customerorder.domain.model.interfaces.IToBeOfferInstance;
import com.ai.crm.customerorder.domain.model.interfaces.IToBeProduct;

public class NewProductSelected extends BaseEvent {
	private IToBeOfferInstance toBeOfferInstance;
	private IToBeProduct toBeProduct;
	public IToBeOfferInstance getToBeOfferInstance() {
		return toBeOfferInstance;
	}

	public void setToBeOfferInstance(IToBeOfferInstance toBeOfferInstance) {
		this.toBeOfferInstance = toBeOfferInstance;
	}

	public IToBeProduct getToBeProduct() {
		return toBeProduct;
	}

	public void setToBeProduct(IToBeProduct toBeProduct) {
		this.toBeProduct = toBeProduct;
	}
	
	public NewProductSelected(Object source) {
		super(source);
	}

}
