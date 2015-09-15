package com.ai.crm.customerorder.domain.model.interfaces;

import com.ai.crm.common.characteristic.domain.model.interfaces.ICharacteristicValue;

public interface IOrderPriceCharacteristicValue {
	ICharacteristicValue getCharacteristicValue();
	void setCharacteristicValue(ICharacteristicValue value);
	IOrderPrice getOrderPrice();
	void setOrderPrice(IOrderPrice orderPrice);
}
