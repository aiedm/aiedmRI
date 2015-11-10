package com.ai.crm.customerorder.domain.model;

import com.ai.crm.product.domain.model.ProductPriceRel;

public class ToBeProductPriceRel extends ProductPriceRel{
	private ProductPriceRel asIsProductPriceRel;
	public ToBeProductPriceRel() {
	}

	public ProductPriceRel getAsIsProductPriceRel() {
		return this.asIsProductPriceRel;
	}

	public void setAsIsProductPriceRel(ProductPriceRel productPriceRel) {
		this.asIsProductPriceRel=productPriceRel;
	}


}
