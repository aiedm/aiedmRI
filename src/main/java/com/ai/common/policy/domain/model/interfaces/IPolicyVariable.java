package com.ai.common.policy.domain.model.interfaces;

import com.ai.common.rootentity.domain.model.interfaces.ICharacteristicSpec;
import com.ai.common.rootentity.domain.model.interfaces.IInstanceEntity;

public interface IPolicyVariable extends IInstanceEntity {
	Object getVariableType();
	void setVariableType(String type);
	ICharacteristicSpec getEnumCharacteristic();
	void setEnumCharacteristic(ICharacteristicSpec characteristicSpec);	
}
