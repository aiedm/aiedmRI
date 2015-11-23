package com.ai.crm.customerorder.domain.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ai.crm.product.domain.model.AsIsProductPriceRel;
import com.ai.crm.product.domain.model.ProductPriceRel;
@Entity
@Table(name="ORD_TOBE__PRODUCT_PRICE_REL")
public class ToBeProductPriceRel extends ProductPriceRel{
	@OneToOne
	private AsIsProductPriceRel asIsProductPriceRel;
	
	@ManyToOne
	private ToBeProduct product;
	@ManyToOne
	private ToBePricePlanInstance price;
	public ToBeProduct getProduct() {
		return this.product;
	}

	
	public void setProduct(ToBeProduct product) {
		this.product=product;
	}

	
	public ToBePricePlanInstance getPricePlanInstance() {
		return this.price;
	}

	
	public void setPricePlanInstance(ToBePricePlanInstance price) {
		this.price=price;
	}
	
	public ToBeProductPriceRel() {
	}

	public AsIsProductPriceRel getAsIsProductPriceRel() {
		return this.asIsProductPriceRel;
	}

	public void setAsIsProductPriceRel(AsIsProductPriceRel productPriceRel) {
		this.asIsProductPriceRel=productPriceRel;
	}


}
