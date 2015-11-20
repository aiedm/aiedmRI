package com.ai.crm.product.domain.repository.interfaces;

import com.ai.crm.product.domain.model.AsIsOfferInstance;
import com.ai.crm.product.domain.model.AsIsPricePlanInstance;
import com.ai.crm.product.domain.model.AsIsProduct;


public interface IProductRepository {
	AsIsOfferInstance getOfferInstanceById(long offerInstanceId) throws Exception;
	AsIsProduct getProductById(long productId) throws Exception;
	AsIsPricePlanInstance getPricePlanInstanceById(long pricePlanInstanceId) throws Exception;
}
