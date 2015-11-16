package com.ai.crm.product.domain.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.ai.common.rootentity.domain.model.InstanceEntity;
@Entity
public class OfferInstanceProductRel extends InstanceEntity {
	@ManyToOne
	@JoinColumn(name="OFFER_INSTANCE_ID")
	private OfferInstance offerInstance;
	@ManyToOne
	@JoinColumn(name="PRODUCT_ID")
	private Product product;

	public OfferInstanceProductRel() {
	}

	public OfferInstance getOfferInstance() {
		return offerInstance;
	}

	public void setOfferInstance(OfferInstance offerInstance) {
		this.offerInstance = offerInstance;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
