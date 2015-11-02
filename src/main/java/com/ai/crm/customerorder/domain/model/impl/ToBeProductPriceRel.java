package com.ai.crm.customerorder.domain.model.impl;

import com.ai.crm.customerorder.domain.model.interfaces.IToBeProductPriceRel;
import com.ai.crm.product.domain.model.impl.ProductPriceRel;
import com.ai.crm.product.domain.model.interfaces.IProductPriceRel;

public class ToBeProductPriceRel extends ProductPriceRel implements IToBeProductPriceRel {
	private IProductPriceRel asIsProductPriceRel;
	public ToBeProductPriceRel() {
	}

	@Override
	public IProductPriceRel getAsIsProductPriceRel() {
		return this.asIsProductPriceRel;
	}

	@Override
	public void setAsIsProductPriceRel(IProductPriceRel productPriceRel) {
		this.asIsProductPriceRel=productPriceRel;
	}


}
