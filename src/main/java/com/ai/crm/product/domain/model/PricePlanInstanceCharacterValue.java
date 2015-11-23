package com.ai.crm.product.domain.model;

import javax.persistence.MappedSuperclass;

import com.ai.common.rootentity.domain.model.CharacteristicSpecValue;
import com.ai.common.rootentity.domain.model.SpecInstanceEntityCharacterValue;
@MappedSuperclass
public abstract class PricePlanInstanceCharacterValue extends SpecInstanceEntityCharacterValue {
	public PricePlanInstanceCharacterValue(){
		
	}
	public PricePlanInstanceCharacterValue(PricePlanInstanceCharacter instanceEntityCharacteristic,
			CharacteristicSpecValue characteristicValue) {
		super(instanceEntityCharacteristic, characteristicValue);
	}
}
