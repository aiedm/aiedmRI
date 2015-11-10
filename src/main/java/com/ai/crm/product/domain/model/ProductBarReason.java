package com.ai.crm.product.domain.model;

import org.springframework.stereotype.Component;

import com.ai.common.rootentity.domain.model.InstanceEntity;
@Component
public class ProductBarReason extends InstanceEntity {
	private Product product;
	private int barCode;
	public ProductBarReason() {
		// TODO Auto-generated constructor stub
	}

	
	public int getBarCode() {
		return this.barCode;
	}

	
	public void setBarCode(int barCode) {
		this.barCode=barCode;
	}

	
	public Product getProduct() {
		return this.product;
	}

	
	public void setProduct(Product product) {
		this.product=product;
	}

}
