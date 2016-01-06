package com.ai.crm.customerorder.domain.model;

import javax.persistence.ManyToOne;

public class ToBeNetworkProduct extends ToBeProduct {
	@ManyToOne(optional=true)
	private ToBeSubscriber subscriber;
	public ToBeNetworkProduct() {
		
	}
	public ToBeSubscriber getSubscriber() {
		return subscriber;
	}
	

	public void setSubscriber(ToBeSubscriber subscriber) {
		this.subscriber = subscriber;
	}
}
