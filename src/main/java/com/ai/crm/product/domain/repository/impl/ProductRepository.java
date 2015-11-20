package com.ai.crm.product.domain.repository.impl;

import org.springframework.stereotype.Component;

import com.ai.crm.product.domain.model.AsIsOfferInstance;
import com.ai.crm.product.domain.model.AsIsPricePlanInstance;
import com.ai.crm.product.domain.model.AsIsProduct;
import com.ai.crm.product.domain.repository.interfaces.IProductRepository;
@Component
public class ProductRepository implements IProductRepository {

	public ProductRepository() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public AsIsOfferInstance getOfferInstanceById(long offerInstanceId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AsIsProduct getProductById(long productId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AsIsPricePlanInstance getPricePlanInstanceById(long pricePlanInstanceId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
