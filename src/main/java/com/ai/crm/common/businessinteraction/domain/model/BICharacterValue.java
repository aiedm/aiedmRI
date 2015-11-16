package com.ai.crm.common.businessinteraction.domain.model;

import com.ai.common.rootentity.domain.model.CharacteristicSpecValue;
import com.ai.common.rootentity.domain.model.SpecInstanceEntityCharacter;
import com.ai.common.rootentity.domain.model.SpecInstanceEntityCharacterValue;

public class BICharacterValue extends SpecInstanceEntityCharacterValue {

	public BICharacterValue() {
	}

	public BICharacterValue(SpecInstanceEntityCharacter instanceEntityCharacteristic, CharacteristicSpecValue characteristicValue) {
		super(instanceEntityCharacteristic, characteristicValue);
	}

}
