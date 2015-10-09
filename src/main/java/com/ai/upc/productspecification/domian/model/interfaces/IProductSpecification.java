package com.ai.upc.productspecification.domian.model.interfaces;

import com.ai.common.rootentity.interfaces.ISpecificationEntity;

public interface IProductSpecification extends ISpecificationEntity {
	long getProductSpecificationId();
	void setProductSpecificationId(long productSpecificationId);
	boolean isAccessProduct();
	void setAccessProduct(boolean isAccessProduct);	
}
