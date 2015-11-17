package com.ai.crm.product.domain.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.ai.common.rootentity.domain.model.CharacteristicSpecValue;
import com.ai.common.rootentity.domain.model.SpecInstanceEntityCharacter;
import com.ai.common.rootentity.domain.model.SpecInstanceEntityCharacterValue;
@Entity
public class PricePlanInstanceCharacterValue extends SpecInstanceEntityCharacterValue {
	@ManyToOne
	private PricePlanInstanceCharacter pricePlanInstanceCharacter;
	public PricePlanInstanceCharacterValue() {
	}

	public PricePlanInstanceCharacterValue(SpecInstanceEntityCharacter instanceEntityCharacteristic,
			CharacteristicSpecValue characteristicValue) {
		super(instanceEntityCharacteristic, characteristicValue);
	}

	public PricePlanInstanceCharacter getPricePlanInstanceCharacter() {
		return pricePlanInstanceCharacter;
	}

	public void setPricePlanInstanceCharacter(PricePlanInstanceCharacter pricePlanInstanceCharacter) {
		this.pricePlanInstanceCharacter = pricePlanInstanceCharacter;
	}

}
