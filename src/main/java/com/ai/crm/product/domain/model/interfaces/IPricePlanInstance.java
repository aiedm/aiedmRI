package com.ai.crm.product.domain.model.interfaces;

import java.util.Set;

public interface IPricePlanInstance {
	long getPricePlanInstanceId();
	void setPricePlanInstanceId(long pricePlanInstanceId);
	Set<IPricePlanInstanceCharacteristicValue> getCharacteristics();
	void addCharacteristic(IPricePlanInstanceCharacteristicValue pricePlanInstanceCharacteristic);
	IOfferInstance getOfferInstance();
	void setOfferInstance(IOfferInstance offerInstance);
	Set<IProduct> getAssignedTo();
	void assignTo(IProduct product);
	long getPricePlanId();
	void setPricePlanId(long pricePlanId);
}
