package com.ai.crm.product.domain.model.interfaces;

import com.ai.common.rootentity.domain.model.interfaces.IInstanceEntity;

public interface IProductPriceRel extends IInstanceEntity {
	IProduct getProduct();
	void setProduct(IProduct product);
	IPricePlanInstance getPricePlanInstance();
	void setPricePlanInstance(IPricePlanInstance price);
}
