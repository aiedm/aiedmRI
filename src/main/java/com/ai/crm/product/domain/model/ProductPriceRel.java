package com.ai.crm.product.domain.model;

import org.springframework.stereotype.Component;

import com.ai.common.rootentity.domain.model.InstanceEntity;
@Component
public class ProductPriceRel extends InstanceEntity{
	private Product product;
	private PricePlanInstance price;
	public ProductPriceRel() {
	}

	
	public Product getProduct() {
		return this.product;
	}

	
	public void setProduct(Product product) {
		this.product=product;
	}

	
	public PricePlanInstance getPricePlanInstance() {
		return this.price;
	}

	
	public void setPricePlanInstance(PricePlanInstance price) {
		this.price=price;
	}

}
