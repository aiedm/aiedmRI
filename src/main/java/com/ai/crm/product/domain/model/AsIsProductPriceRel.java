package com.ai.crm.product.domain.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="PD_PRODUCT_PRICE_REL")
public class AsIsProductPriceRel extends ProductPriceRel{
	@ManyToOne
	private AsIsProduct product;
	@ManyToOne
	private AsIsPricePlanInstance price;
	public AsIsProduct getProduct() {
		return this.product;
	}

	
	public void setProduct(AsIsProduct product) {
		this.product=product;
	}

	
	public AsIsPricePlanInstance getPricePlanInstance() {
		return this.price;
	}

	
	public void setPricePlanInstance(AsIsPricePlanInstance price) {
		this.price=price;
	}	
}
