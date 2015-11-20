package com.ai.crm.product.domain.model;

import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.ai.common.rootentity.domain.model.CharacteristicSpecValue;
import com.ai.common.rootentity.domain.model.SpecInstanceEntityCharacter;
import com.ai.common.rootentity.domain.model.SpecInstanceEntityCharacterValue;
@MappedSuperclass
public class OfferInstanceCharacterValue extends SpecInstanceEntityCharacterValue {
	@ManyToOne
	private  OfferInstanceCharacter offerInstanceCharacter;
	public OfferInstanceCharacterValue() {
	}

	public OfferInstanceCharacterValue(SpecInstanceEntityCharacter instanceEntityCharacteristic,
			CharacteristicSpecValue characteristicValue) {
		super(instanceEntityCharacteristic, characteristicValue);
	}

	public OfferInstanceCharacter getOfferInstanceCharacter() {
		return offerInstanceCharacter;
	}

	public void setOfferInstanceCharacter(OfferInstanceCharacter offerInstanceCharacter) {
		this.offerInstanceCharacter = offerInstanceCharacter;
	}

}
