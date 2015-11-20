package com.ai.crm.product.domain.model;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.ai.common.rootentity.domain.model.InstanceEntity;
@MappedSuperclass
public class OfferInstanceProductRel extends InstanceEntity {
	@Id
	private long id;
	
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
