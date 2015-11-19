package com.ai.crm.customerorder.domain.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ai.crm.product.domain.model.OfferInstance;
@Entity
@Table(name="ORD_TOBE_OFFER_INS")
public class ToBeOfferInstance extends OfferInstance{
	@OneToOne
	private OfferInstance asIsOfferInstance;
	public ToBeOfferInstance() {
	}

	public OfferInstance getAsIsOfferInstance() {
		return asIsOfferInstance;
	}

	public void setAsIsOfferInstance(OfferInstance offerInstance) {
		this.asIsOfferInstance=offerInstance;
	}

}
