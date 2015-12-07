package com.ai.common.rootentity.domain.repository.impl;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.ai.common.rootentity.domain.model.CharacteristicSpec;
import com.ai.common.rootentity.domain.model.CharacteristicSpecValue;
import com.ai.common.rootentity.domain.repository.interfaces.ICharacteristiceSpecRepository;
@Component
public class CharacteristiceSpecRepository extends BaseRepository implements ICharacteristiceSpecRepository {

	public CharacteristiceSpecRepository() {
	}

	@Override
	public CharacteristicSpec saveCharactericSpec(CharacteristicSpec characteristicSpec) {
		Serializable id = currentSession().save(characteristicSpec);
		characteristicSpec.setId((Long)id);
		return characteristicSpec;
	}

	@Override
	public CharacteristicSpecValue saveCharactericSpecValue(CharacteristicSpecValue characteristicSpecValue) {
		Serializable id = currentSession().save(characteristicSpecValue);
		characteristicSpecValue.setId((Long)id);
		return characteristicSpecValue;
	}

}
