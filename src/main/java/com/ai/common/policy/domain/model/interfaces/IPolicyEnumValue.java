package com.ai.common.policy.domain.model.interfaces;

import java.util.Set;

import com.ai.common.rootentity.domain.model.interfaces.ICharacteristicSpecValue;

public interface IPolicyEnumValue extends IPolicyValue {
	Set<ICharacteristicSpecValue> getEnumValues();
	void addEnumValue(ICharacteristicSpecValue value);
	ICharacteristicSpecValue getEnumValue();
	void setEnumValue(ICharacteristicSpecValue value);
}
