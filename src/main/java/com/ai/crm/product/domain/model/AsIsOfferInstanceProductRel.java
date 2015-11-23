package com.ai.crm.product.domain.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="PD_OFFER_INS_PRODUCT_REL")
public class AsIsOfferInstanceProductRel extends OfferInstanceProductRel {
	@ManyToOne
	@JoinColumn(name="OFFER_INSTANCE_ID")
	private AsIsOfferInstance offerInstance;
	
	@ManyToOne
	@JoinColumn(name="PRODUCT_ID")
	private AsIsProduct product;
	

	public AsIsProduct getProduct() {
		return product;
	}

	public void setProduct(AsIsProduct product) {
		this.product = product;
	}
	
	public AsIsOfferInstance getOfferInstance() {
		return offerInstance;
	}

	public void setOfferInstance(AsIsOfferInstance offerInstance) {
		this.offerInstance = offerInstance;
	}
}
