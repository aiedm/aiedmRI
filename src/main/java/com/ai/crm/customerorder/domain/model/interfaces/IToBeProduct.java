package com.ai.crm.customerorder.domain.model.interfaces;

import com.ai.crm.product.domain.model.interfaces.IProduct;

public interface IToBeProduct extends IProduct {
	IProduct getAsIsProduct();
	void setAsIsProduct(IProduct product);
	
}
