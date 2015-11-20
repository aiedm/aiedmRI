package com.ai.crm.customerorder.domain.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ai.crm.product.domain.model.AsIsOfferInstance;
import com.ai.crm.product.domain.model.OfferInstance;
@Entity
@Table(name="ORD_TOBE_OFFER_INS")
public class ToBeOfferInstance extends OfferInstance{
	@OneToOne
	private AsIsOfferInstance asIsOfferInstance;
	public ToBeOfferInstance() {
	}

	public AsIsOfferInstance getAsIsOfferInstance() {
		return asIsOfferInstance;
	}

	public void setAsIsOfferInstance(AsIsOfferInstance offerInstance) {
		this.asIsOfferInstance=offerInstance;
	}

}
