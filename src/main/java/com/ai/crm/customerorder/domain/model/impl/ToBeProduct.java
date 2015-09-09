package com.ai.crm.customerorder.domain.model.impl;

import com.ai.crm.customerorder.domain.model.interfaces.IProductOrder;
import com.ai.crm.customerorder.domain.model.interfaces.IToBeProduct;
import com.ai.crm.product.domain.model.impl.Product;

public class ToBeProduct extends Product implements IToBeProduct {

	public ToBeProduct() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public IProductOrder getProductOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setProductOrder(IProductOrder productOrder) {
		// TODO Auto-generated method stub

	}

}
