package com.ai.crm.product.domain.model.interfaces;

import com.ai.crm.common.rootentity.interfaces.ICharacteristicSpecValue;

public interface IProductCharacteristicValue {
	ICharacteristicSpecValue getCharacteristicValue();
	void setCharacteristicValue(ICharacteristicSpecValue value);
}
