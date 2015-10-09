package com.ai.upc.productspecification.domian.model.interfaces;

import java.util.Set;

public interface INetworkProductSpecification extends IProductSpecification {
	Set<IAttachingProductSpecification> getAttachingProductSpecifications();
	void addAttachingProductSpecification(IAttachingProductSpecification attachingProductSpecification);
}
