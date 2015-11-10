package com.ai.crm.customerorder.domain.model;

import org.springframework.stereotype.Component;

import com.ai.crm.product.domain.model.Product;
@Component
public class ToBeProduct extends Product{
	private Product asIsProduct;
	public ToBeProduct() {
	}

	
	public Product getAsIsProduct() {
		return asIsProduct;
	}

	
	public void setAsIsProduct(Product product) {
		this.asIsProduct=product;
	}

}
