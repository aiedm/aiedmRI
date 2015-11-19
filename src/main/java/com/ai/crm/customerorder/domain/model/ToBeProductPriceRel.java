package com.ai.crm.customerorder.domain.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ai.crm.product.domain.model.ProductPriceRel;
@Entity
@Table(name="ORD_TOBE__PRODUCT_PRICE_REL")
public class ToBeProductPriceRel extends ProductPriceRel{
	@OneToOne
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
