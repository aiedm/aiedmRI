package com.ai.crm.product.domain.repository.impl;

import org.springframework.stereotype.Component;

import com.ai.crm.product.domain.model.OfferInstance;
import com.ai.crm.product.domain.model.PricePlanInstance;
import com.ai.crm.product.domain.model.Product;
import com.ai.crm.product.domain.repository.interfaces.IProductRepository;
@Component
public class ProductRepository implements IProductRepository {

	public ProductRepository() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public OfferInstance getOfferInstanceById(long offerInstanceId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getProductById(long productId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PricePlanInstance getPricePlanInstanceById(long pricePlanInstanceId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
