package com.ai.upc.productspecification.domian.repository.impl;

import org.springframework.stereotype.Component;

import com.ai.upc.productspecification.domian.model.interfaces.IProductSpecification;
import com.ai.upc.productspecification.domian.repository.interfaces.IProductSpecificationRepository;
@Component
public class ProductSpecificationRepository implements IProductSpecificationRepository {

	public ProductSpecificationRepository() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public IProductSpecification getProductSpecificationById(long ProductSpecificationId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IProductSpecification getProductSpecificationByCode(String ProductSpecificationCode) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
