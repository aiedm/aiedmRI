package com.ai.crm.customerorder.domain.model.interfaces;

import com.ai.crm.common.characteristic.domain.model.interfaces.ICharacteristicValue;

public interface IOfferOrderCharacteristicValue {
	IOfferOrder getOfferOrder();
	void setOfferOrder(IOfferOrder offerOrder);
	ICharacteristicValue getCharacteristicValue();
	void setCharacteristicValue(ICharacteristicValue value);
}
