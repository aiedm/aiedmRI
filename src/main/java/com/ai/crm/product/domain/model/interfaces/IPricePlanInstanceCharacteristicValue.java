package com.ai.crm.product.domain.model.interfaces;

import com.ai.common.rootentity.domain.model.interfaces.ICharacteristicSpecValue;

public interface IPricePlanInstanceCharacteristicValue {
	ICharacteristicSpecValue getCharacteristicValue();
	void setCharacteristicValue(ICharacteristicSpecValue value);
}
