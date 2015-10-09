package com.ai.upc.priceplan.domain.model.interfaces;

import com.ai.common.rootentity.interfaces.ISpecificationEntity;

public interface IPricePlan extends ISpecificationEntity{
	long getPricePlanId();
	void setPricePlanId();
}
