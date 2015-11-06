package com.ai.common.rootentity.domain.repository.interfaces;

import com.ai.common.rootentity.domain.model.interfaces.ICharacteristicSpec;
import com.ai.common.rootentity.domain.model.interfaces.ICharacteristicSpecValue;

public interface ICharacterSpecificationRepository {
	ICharacteristicSpec getCharacteristicSpecById(long characteristicSpecId) throws Exception;
	ICharacteristicSpecValue getCharacteristicSpecValueById(long characteristicSpecValueId) throws Exception;

}
