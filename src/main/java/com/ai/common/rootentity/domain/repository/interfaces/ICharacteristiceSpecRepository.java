package com.ai.common.rootentity.domain.repository.interfaces;

import com.ai.common.rootentity.domain.model.CharacteristicSpec;
import com.ai.common.rootentity.domain.model.CharacteristicSpecValue;

public interface ICharacteristiceSpecRepository {
	CharacteristicSpec saveCharactericSpec(CharacteristicSpec characteristicSpec);
	CharacteristicSpecValue saveCharactericSpecValue(CharacteristicSpecValue characteristicSpecValue);
}
