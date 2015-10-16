package com.ai.crm.product.domain.model.interfaces;

import com.ai.common.rootentity.domain.model.interfaces.ICharacteristicSpecValue;
import com.ai.common.rootentity.domain.model.interfaces.IInstanceEntity;

public interface IOfferInstanceCharacteristicValue extends IInstanceEntity{
	ICharacteristicSpecValue getCharacteristicValue();
	void setCharacteristicValue(ICharacteristicSpecValue value);
}
