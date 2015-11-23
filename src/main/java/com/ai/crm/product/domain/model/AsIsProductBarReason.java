package com.ai.crm.product.domain.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="PD_PRODUCT_BAR_REASON")
public class AsIsProductBarReason extends ProductBarReason {
	@ManyToOne
	private AsIsProduct product;
	public AsIsProduct getProduct() {
		return this.product;
	}

	
	public void setProduct(AsIsProduct product) {
		this.product=product;
	}	
}
