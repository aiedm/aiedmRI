package com.ai.crm.product.domain.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ai.common.rootentity.domain.model.CharacteristicSpecValue;
import com.ai.common.rootentity.domain.model.SpecInstanceEntityCharacter;
@Entity
@Table(name="PD_OFFER_INS_CHARACTER_VALUE")
public class AsIsOfferInstanceCharacterValue extends OfferInstanceCharacterValue {
	@ManyToOne
	private  AsIsOfferInstanceCharacter offerInstanceCharacter;

	public AsIsOfferInstanceCharacterValue() {
	}
	
	public AsIsOfferInstanceCharacterValue(AsIsOfferInstanceCharacter offerInstanceCharacter,
			CharacteristicSpecValue characteristicValue) {
		super((SpecInstanceEntityCharacter)offerInstanceCharacter,(CharacteristicSpecValue)characteristicValue);
	}
	


	public AsIsOfferInstanceCharacter getOfferInstanceCharacter() {
		return offerInstanceCharacter;
	}

	public void setOfferInstanceCharacter(AsIsOfferInstanceCharacter offerInstanceCharacter) {
		this.offerInstanceCharacter = offerInstanceCharacter;
	}

}
