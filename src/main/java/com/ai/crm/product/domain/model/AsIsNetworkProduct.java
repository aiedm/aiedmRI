package com.ai.crm.product.domain.model;

import javax.persistence.ManyToOne;

public class AsIsNetworkProduct extends AsIsProduct {
	@ManyToOne
	private AsIsSubscriber subscriber;
	public AsIsNetworkProduct() {
		// TODO Auto-generated constructor stub
	}
	public AsIsSubscriber getSubscriber() {
		return subscriber;
	}
	
	public void setSubscriber(AsIsSubscriber subscriber) {
		this.subscriber = subscriber;
	}
	

}
