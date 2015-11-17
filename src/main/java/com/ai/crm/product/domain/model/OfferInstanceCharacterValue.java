package com.ai.crm.product.domain.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.ai.common.rootentity.domain.model.CharacteristicSpecValue;
import com.ai.common.rootentity.domain.model.SpecInstanceEntityCharacter;
import com.ai.common.rootentity.domain.model.SpecInstanceEntityCharacterValue;
@Entity
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
