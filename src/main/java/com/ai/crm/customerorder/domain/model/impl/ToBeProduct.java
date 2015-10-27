package com.ai.crm.customerorder.domain.model.impl;

import org.springframework.stereotype.Component;

import com.ai.crm.customerorder.domain.model.interfaces.IProductOrderItem;
import com.ai.crm.customerorder.domain.model.interfaces.IToBeProduct;
import com.ai.crm.product.domain.model.impl.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Component
public class ToBeProduct extends Product implements IToBeProduct {
	@JsonIgnore
	private IProductOrderItem productOrder;

	public ToBeProduct() {
	}
	
	public ToBeProduct(IProductOrderItem productOrder) {
		this.setProductOrder(productOrder);
	}

	@Override
	public IProductOrderItem getProductOrder() {
		return this.productOrder;
	}

	@Override
	public void setProductOrder(IProductOrderItem productOrder) {
		 this.productOrder= productOrder;
	}

}
