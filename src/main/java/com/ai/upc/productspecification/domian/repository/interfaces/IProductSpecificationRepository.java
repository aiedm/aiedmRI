package com.ai.upc.productspecification.domian.repository.interfaces;

import com.ai.upc.productspecification.domian.model.ProductSpecification;

public interface IProductSpecificationRepository {
	ProductSpecification getProductSpecificationById(long ProductSpecificationId) throws Exception;
	ProductSpecification getProductSpecificationByCode(String ProductSpecificationCode) throws Exception;
}
