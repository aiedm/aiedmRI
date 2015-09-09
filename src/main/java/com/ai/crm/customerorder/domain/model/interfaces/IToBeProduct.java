package com.ai.crm.customerorder.domain.model.interfaces;

import com.ai.crm.product.domain.model.interfaces.IProduct;

public interface IToBeProduct extends IProduct {
	IProductOrder getProductOrder();
	void setProductOrder(IProductOrder productOrder);
}
