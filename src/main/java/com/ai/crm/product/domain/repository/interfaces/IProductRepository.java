package com.ai.crm.product.domain.repository.interfaces;

import com.ai.crm.product.domain.model.OfferInstance;
import com.ai.crm.product.domain.model.PricePlanInstance;
import com.ai.crm.product.domain.model.Product;


public interface IProductRepository {
	OfferInstance getOfferInstanceById(long offerInstanceId) throws Exception;
	Product getProductById(long productId) throws Exception;
	PricePlanInstance getPricePlanInstanceById(long pricePlanInstanceId) throws Exception;
}
