package com.ai.crm.product.domain.model.interfaces;

import com.ai.crm.common.rootentity.interfaces.ICharacteristicSpecValue;

public interface IPricePlanInstanceCharacteristicValue {
	ICharacteristicSpecValue getCharacteristicValue();
	void setCharacteristicValue(ICharacteristicSpecValue value);
}
