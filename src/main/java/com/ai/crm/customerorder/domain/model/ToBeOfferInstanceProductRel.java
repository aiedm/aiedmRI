package com.ai.crm.customerorder.domain.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ai.crm.product.domain.model.OfferInstanceProductRel;
@Entity
@Table(name="ORD_TOBE_OFFER_INS_PRODUCT_REL")
public class ToBeOfferInstanceProductRel extends OfferInstanceProductRel {
	@ManyToOne
	@JoinColumn(name="OFFER_INSTANCE_ID")
	private ToBeOfferInstance offerInstance;
	
	@ManyToOne
	@JoinColumn(name="PRODUCT_ID")
	private ToBeProduct product;
	

	public ToBeProduct getProduct() {
		return product;
	}

	public void setProduct(ToBeProduct product) {
		this.product = product;
	}
	
	public ToBeOfferInstance getOfferInstance() {
		return offerInstance;
	}

	public void setOfferInstance(ToBeOfferInstance offerInstance) {
		this.offerInstance = offerInstance;
	}
}
