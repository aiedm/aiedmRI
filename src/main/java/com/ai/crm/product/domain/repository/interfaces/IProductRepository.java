package com.ai.crm.product.domain.repository.interfaces;

import com.ai.crm.product.domain.model.interfaces.IOfferInstance;
import com.ai.crm.product.domain.model.interfaces.IPricePlanInstance;
import com.ai.crm.product.domain.model.interfaces.IProduct;

public interface IProductRepository {
	IOfferInstance getOfferInstanceById(long offerInstanceId) throws Exception;
	IProduct getProductById(long productId) throws Exception;
	IPricePlanInstance getPricePlanInstanceById(long pricePlanInstanceId) throws Exception;
}
