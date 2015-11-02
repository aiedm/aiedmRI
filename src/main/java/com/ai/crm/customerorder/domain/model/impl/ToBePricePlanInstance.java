package com.ai.crm.customerorder.domain.model.impl;

import org.springframework.stereotype.Component;

import com.ai.crm.customerorder.domain.model.interfaces.IToBePricePlanInstance;
import com.ai.crm.product.domain.model.impl.PricePlanInstance;
import com.ai.crm.product.domain.model.interfaces.IPricePlanInstance;
@Component
public class ToBePricePlanInstance extends PricePlanInstance implements IToBePricePlanInstance {
	private IPricePlanInstance asIsPricePlanInstance;
	@Override
	public IPricePlanInstance getAsIsPricePlanInstance() {
		return asIsPricePlanInstance;
	}

	@Override
	public void setAsIsPricePlanInstance(IPricePlanInstance pricePlanInstance) {
		this.asIsPricePlanInstance=pricePlanInstance;
	}

}
