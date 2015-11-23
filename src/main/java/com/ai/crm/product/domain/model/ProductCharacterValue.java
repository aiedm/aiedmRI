package com.ai.crm.product.domain.model;

import javax.persistence.MappedSuperclass;

import com.ai.common.rootentity.domain.model.CharacteristicSpecValue;
import com.ai.common.rootentity.domain.model.SpecInstanceEntityCharacter;
import com.ai.common.rootentity.domain.model.SpecInstanceEntityCharacterValue;
@MappedSuperclass
public abstract class ProductCharacterValue extends SpecInstanceEntityCharacterValue {
	public ProductCharacterValue(){
		
	}
	
	public ProductCharacterValue(ProductCharacter instanceEntityCharacteristic,
			CharacteristicSpecValue characteristicValue) {
		super((SpecInstanceEntityCharacter)instanceEntityCharacteristic, characteristicValue);
	}
}
