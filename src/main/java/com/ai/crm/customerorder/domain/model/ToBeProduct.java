package com.ai.crm.customerorder.domain.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ai.crm.product.domain.model.Product;
@Entity
@Table(name="ORD_TOBE_PRODUCT")
public class ToBeProduct extends Product{
	@OneToOne
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
