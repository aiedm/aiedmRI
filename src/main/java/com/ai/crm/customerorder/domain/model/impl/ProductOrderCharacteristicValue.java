package com.ai.crm.customerorder.domain.model.impl;

import org.springframework.stereotype.Component;

import com.ai.crm.common.characteristic.domain.model.interfaces.ICharacteristicValue;
import com.ai.crm.customerorder.domain.model.interfaces.IProductOrder;
import com.ai.crm.customerorder.domain.model.interfaces.IProductOrderCharacteristicValue;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Component
public class ProductOrderCharacteristicValue implements IProductOrderCharacteristicValue {
	@JsonIgnore
	private IProductOrder productOrder;
	private ICharacteristicValue value;
	public ProductOrderCharacteristicValue() {
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
	public IProductOrder getProductOrder() {
		return this.productOrder;
	}

	@Override
	public void setProductOrder(IProductOrder productOrder) {
		this.productOrder=productOrder;
	}


}
