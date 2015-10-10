package com.ai.upc.productspecification.domian.model.interfaces;

import java.util.Set;

import com.ai.common.rootentity.domain.model.interfaces.ISpecificationEntity;

public interface IProductLine extends ISpecificationEntity {
	long getProductLineId();
	void setProductLineId();
	IAccessProductSpecification getAccessProductSpec();
	void setAccessProduct(IAttachingProductSpecification accessProductSpec);
	Set<IAttachingProductSpecification> getAttachingProducts();
	void addAttachingProductSpec(IAttachingProductSpecification AttachingProductSpec);
	Set<IProductSpecification> getContainedProductSpecs();
}
