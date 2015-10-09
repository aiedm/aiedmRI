package com.ai.upc.productspecification.domian.model.interfaces;

public interface IEContentProductSpecification extends IProductSpecification {
	IAttachingProductSpecification getDependentProductSpecification();
	void setDependentProductSpecification(IAttachingProductSpecification dependentProductSpecification);
}
