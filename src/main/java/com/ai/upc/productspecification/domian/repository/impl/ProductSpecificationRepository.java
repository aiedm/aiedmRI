package com.ai.upc.productspecification.domian.repository.impl;

import org.springframework.stereotype.Component;

import com.ai.upc.productspecification.domian.model.ProductSpecification;
import com.ai.upc.productspecification.domian.repository.interfaces.IProductSpecificationRepository;
@Component
public class ProductSpecificationRepository implements IProductSpecificationRepository {

	public ProductSpecificationRepository() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ProductSpecification getProductSpecificationById(long ProductSpecificationId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductSpecification getProductSpecificationByCode(String ProductSpecificationCode) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
