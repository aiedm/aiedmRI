package com.ai.crm.customerorder.domain.model.impl;

import org.springframework.stereotype.Component;

import com.ai.crm.common.characteristic.domain.model.interfaces.ICharacteristicValue;
import com.ai.crm.customerorder.domain.model.interfaces.IOfferOrder;
import com.ai.crm.customerorder.domain.model.interfaces.IOfferOrderCharacteristicValue;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Component
public class OfferOrderCharacteristicValue implements IOfferOrderCharacteristicValue {
	@JsonIgnore
	private IOfferOrder offerOrder;
	private ICharacteristicValue value;
	public OfferOrderCharacteristicValue() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ICharacteristicValue getCharacteristicValue() {
		return this.value;
	}

	@Override
	public void setCharacteristicValue(ICharacteristicValue value) {
		this.value=value;
	}

	@Override
	public IOfferOrder getOfferOrder() {
		return this.offerOrder;
	}

	@Override
	public void setOfferOrder(IOfferOrder offerOrder) {
		this.offerOrder=offerOrder;
	}

}
