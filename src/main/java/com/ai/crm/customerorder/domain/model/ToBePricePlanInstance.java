package com.ai.crm.customerorder.domain.model;

import org.springframework.stereotype.Component;

import com.ai.crm.product.domain.model.PricePlanInstance;
@Component
public class ToBePricePlanInstance extends PricePlanInstance{
	private PricePlanInstance asIsPricePlanInstance;
	public PricePlanInstance getAsIsPricePlanInstance() {
		return asIsPricePlanInstance;
	}

	public void setAsIsPricePlanInstance(PricePlanInstance pricePlanInstance) {
		this.asIsPricePlanInstance=pricePlanInstance;
	}

}
