package com.ai.crm.customerorder.domain.model.interfaces;

import com.ai.crm.product.domain.model.interfaces.IPricePlanInstance;

public interface IToBePricePlanInstance extends IPricePlanInstance{
	IPricePlanInstance getAsIsPricePlanInstance();
	void setAsIsPricePlanInstance(IPricePlanInstance pricePlanInstance);
}
