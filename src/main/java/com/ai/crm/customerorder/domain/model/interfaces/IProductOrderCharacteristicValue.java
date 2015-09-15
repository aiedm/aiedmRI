package com.ai.crm.customerorder.domain.model.interfaces;

import com.ai.crm.common.characteristic.domain.model.interfaces.ICharacteristicValue;

public interface IProductOrderCharacteristicValue {
	IProductOrder getProductOrder();
	void setProductOrder(IProductOrder productOrder);
	ICharacteristicValue getCharacteristicValue();
	void setCharacteristicValue(ICharacteristicValue value);
}
