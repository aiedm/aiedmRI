package com.ai.upc.productoffering.domain.model.interaces;

import com.ai.common.rootentity.domain.model.interfaces.ISpecificationEntity;
import com.ai.upc.priceplan.domain.model.interfaces.IPricePlan;

public interface IOfferPricePlanRelation extends ISpecificationEntity {
	IProductOffering getOffer();
	void setOffer(IProductOffering offer);
	IPricePlan getPricePlan();
	void setPricePlan(IPricePlan pricePlan);	
}
