package com.ai.common.rootentity.domain.repository.interfaces;

import com.ai.common.rootentity.domain.model.CharacteristicSpec;
import com.ai.common.rootentity.domain.model.CharacteristicSpecValue;

public interface ICharacterSpecificationRepository {
	CharacteristicSpec getCharacteristicSpecById(long characteristicSpecId) throws Exception;
	CharacteristicSpecValue getCharacteristicSpecValueById(long characteristicSpecValueId) throws Exception;

}
