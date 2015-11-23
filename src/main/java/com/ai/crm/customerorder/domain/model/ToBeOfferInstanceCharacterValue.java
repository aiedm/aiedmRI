package com.ai.crm.customerorder.domain.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ai.common.rootentity.domain.model.CharacteristicSpecValue;
import com.ai.common.rootentity.domain.model.SpecInstanceEntityCharacter;
import com.ai.crm.product.domain.model.OfferInstanceCharacterValue;
@Entity
@Table(name="ORD_TOBE_OFFER_INS_CHARACTER_VALUE")
public class ToBeOfferInstanceCharacterValue extends OfferInstanceCharacterValue {
	@ManyToOne
	private  ToBeOfferInstanceCharacter offerInstanceCharacter;

	public ToBeOfferInstanceCharacterValue() {
	}
	
	public ToBeOfferInstanceCharacterValue(ToBeOfferInstanceCharacter offerInstanceCharacter,
			CharacteristicSpecValue characteristicValue) {
		super((SpecInstanceEntityCharacter)offerInstanceCharacter,(CharacteristicSpecValue)characteristicValue);
	}
	
	public ToBeOfferInstanceCharacter getOfferInstanceCharacter() {
		return offerInstanceCharacter;
	}

	public void setOfferInstanceCharacter(ToBeOfferInstanceCharacter offerInstanceCharacter) {
		this.offerInstanceCharacter = offerInstanceCharacter;
	}
}
