package com.ai.crm.customerorder.domain.model.impl;

import org.springframework.stereotype.Component;

import com.ai.crm.customerorder.domain.model.interfaces.IToBeProduct;
import com.ai.crm.product.domain.model.impl.Product;
import com.ai.crm.product.domain.model.interfaces.IProduct;
@Component
public class ToBeProduct extends Product implements IToBeProduct {
	private IProduct asIsProduct;
	public ToBeProduct() {
	}

	@Override
	public IProduct getAsIsProduct() {
		return asIsProduct;
	}

	@Override
	public void setAsIsProduct(IProduct product) {
		this.asIsProduct=product;
	}

}
