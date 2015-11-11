package com.ai.upc.priceplan.domain.model;

public class PricePlan {
	private long pricePlanId;

	public PricePlan() {
	}
	public long getPricePlanId(){
		return this.pricePlanId;
	}
	public void setPricePlanId(long pricePlanId){
		this.pricePlanId=pricePlanId;
	}
}
