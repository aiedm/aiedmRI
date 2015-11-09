package com.ai.crm.customerorder.domain.model.interfaces;

import com.ai.crm.product.domain.model.interfaces.IProductPriceRel;

public interface IToBeProductPriceRel extends IProductPriceRel {
	IProductPriceRel getAsIsProductPriceRel();
	void setAsIsProductPriceRel(IProductPriceRel productPriceRel);
}
