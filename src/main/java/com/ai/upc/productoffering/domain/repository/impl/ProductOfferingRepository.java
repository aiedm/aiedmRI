package com.ai.upc.productoffering.domain.repository.impl;

import org.springframework.stereotype.Component;

import com.ai.upc.productoffering.domain.model.interfaces.IProductOffering;
import com.ai.upc.productoffering.domain.repository.interfaces.IProductOfferingRepository;
@Component
public class ProductOfferingRepository implements IProductOfferingRepository {

	public ProductOfferingRepository() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public IProductOffering getProductOfferingById(long productOfferingId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IProductOffering getProductOfferingByCode(String productOfferingCode) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
