package com.ai.upc.productspecification.domian.repository.interfaces;

import com.ai.upc.productspecification.domian.model.interfaces.IProductSpecification;

public interface IProductSpecificationRepository {
	IProductSpecification getProductSpecificationById(long ProductSpecificationId) throws Exception;
	IProductSpecification getProductSpecificationByCode(String ProductSpecificationCode) throws Exception;
}
