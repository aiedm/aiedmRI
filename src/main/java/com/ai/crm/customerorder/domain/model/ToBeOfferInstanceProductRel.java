package com.ai.crm.customerorder.domain.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ai.crm.product.domain.model.AsIsOfferInstanceProductRel;
import com.ai.crm.product.domain.model.OfferInstanceProductRel;
@Entity
@Table(name="ORD_TOBE_OFFER_INS_PRODUCT_REL")
public class ToBeOfferInstanceProductRel extends OfferInstanceProductRel {
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private AsIsOfferInstanceProductRel asIsOfferInstanceProductRel;
	
	@ManyToOne
	@JoinColumn(name="OFFER_INSTANCE_ID")
	private ToBeOfferInstance offerInstance;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="PRODUCT_ID")
	private ToBeProduct product;
	
	private int action;

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

	public AsIsOfferInstanceProductRel getAsIsOfferInstanceProductRel() {
		return asIsOfferInstanceProductRel;
	}

	public void setAsIsOfferInstanceProductRel(AsIsOfferInstanceProductRel asIsOfferInstanceProductRel) {
		this.asIsOfferInstanceProductRel = asIsOfferInstanceProductRel;
	}

	public int getAction() {
		return action;
	}
	

	public void setAction(int action) {
		this.action = action;
	}
	
}
