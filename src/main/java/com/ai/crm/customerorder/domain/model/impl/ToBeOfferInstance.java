package com.ai.crm.customerorder.domain.model.impl;

import org.springframework.stereotype.Component;

import com.ai.crm.customerorder.domain.model.interfaces.IOfferOrderItem;
import com.ai.crm.customerorder.domain.model.interfaces.IToBeOfferInstance;
import com.ai.crm.product.domain.model.impl.OfferInstance;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Component
public class ToBeOfferInstance extends OfferInstance implements IToBeOfferInstance {
	@JsonIgnore
	private IOfferOrderItem offerOrder;
	public ToBeOfferInstance() {
	}

	@Override
	public IOfferOrderItem getOfferOrder() {
		return this.offerOrder;
	}

	@Override
	public void setOfferOrder(IOfferOrderItem offerOrder) {
		this.offerOrder=offerOrder;
	}

}
