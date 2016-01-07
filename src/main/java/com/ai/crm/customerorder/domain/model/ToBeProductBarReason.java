package com.ai.crm.customerorder.domain.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ai.crm.product.domain.model.ProductBarReason;
@Entity
@Table(name="ORD_TOBE_PRODUCT_BAR_REASON")
public class ToBeProductBarReason extends ProductBarReason {
	@ManyToOne
	private ToBeProduct product;
	
	private int action;
	public ToBeProduct getProduct() {
		return this.product;
	}

	
	public void setProduct(ToBeProduct product) {
		this.product=product;
	}


	public int getAction() {
		return action;
	}
	


	public void setAction(int action) {
		this.action = action;
	}
	
}
