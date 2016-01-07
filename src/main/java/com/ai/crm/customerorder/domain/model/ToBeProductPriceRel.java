package com.ai.crm.customerorder.domain.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ai.crm.product.domain.model.AsIsProductPriceRel;
import com.ai.crm.product.domain.model.ProductPriceRel;
@Entity
@Table(name="ORD_TOBE_PRODUCT_PRICE_REL")
public class ToBeProductPriceRel extends ProductPriceRel{
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private AsIsProductPriceRel asIsProductPriceRel;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="PRODUCT_ID")
	private ToBeProduct product;
	
	@ManyToOne
	private ToBePricePlanInstance price;
	
	private int action;
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


	public int getAction() {
		return action;
	}
	


	public void setAction(int action) {
		this.action = action;
	}
	


}
