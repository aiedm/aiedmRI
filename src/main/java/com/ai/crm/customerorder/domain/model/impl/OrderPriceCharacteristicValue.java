package com.ai.crm.customerorder.domain.model.impl;

import org.springframework.stereotype.Component;

import com.ai.crm.common.characteristic.domain.model.interfaces.ICharacteristicValue;
import com.ai.crm.customerorder.domain.model.interfaces.IOrderPrice;
import com.ai.crm.customerorder.domain.model.interfaces.IOrderPriceCharacteristicValue;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Component
public class OrderPriceCharacteristicValue implements IOrderPriceCharacteristicValue {
	@JsonIgnore
	private IOrderPrice orderPrice;
	private ICharacteristicValue value;

	@Override
	public ICharacteristicValue getCharacteristicValue() {
		return this.value;
	}

	@Override
	public void setCharacteristicValue(ICharacteristicValue value) {
		this.value=value;
	}


	@Override
	public IOrderPrice getOrderPrice() {
		return this.orderPrice;
	}

	@Override
	public void setOrderPrice(IOrderPrice orderPrice) {
		this.orderPrice=orderPrice;
	}

}
