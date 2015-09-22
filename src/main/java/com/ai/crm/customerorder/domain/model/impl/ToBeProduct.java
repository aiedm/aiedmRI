package com.ai.crm.customerorder.domain.model.impl;

import org.springframework.stereotype.Component;

import com.ai.crm.customerorder.domain.model.interfaces.IProductOrder;
import com.ai.crm.customerorder.domain.model.interfaces.IToBeProduct;
import com.ai.crm.product.domain.model.impl.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Component
public class ToBeProduct extends Product implements IToBeProduct {
	@JsonIgnore
	private IProductOrder productOrder;

	private ToBeProduct() {
	}
	
	public ToBeProduct(IProductOrder productOrder) {
		this.setProductOrder(productOrder);
	}

	@Override
	public IProductOrder getProductOrder() {
		return this.productOrder;
	}

	@Override
	public void setProductOrder(IProductOrder productOrder) {
		 this.productOrder= productOrder;
	}

}
