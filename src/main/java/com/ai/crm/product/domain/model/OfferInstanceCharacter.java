package com.ai.crm.product.domain.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.ai.common.rootentity.domain.model.SpecInstanceEntityCharacter;
@Entity
public class OfferInstanceCharacter extends SpecInstanceEntityCharacter {
	@ManyToOne
	private OfferInstance offerInstance;
	@OneToMany(mappedBy="offerInstanceCharacter")
	private Set<OfferInstanceCharacterValue> offerInstanceCharacterValues=new LinkedHashSet<OfferInstanceCharacterValue>();
	public OfferInstanceCharacter() {
	}
	public OfferInstance getOfferInstance() {
		return offerInstance;
	}
	public void setOfferInstance(OfferInstance offerInstance) {
		this.offerInstance = offerInstance;
	}
	public Set<OfferInstanceCharacterValue> getBICharacteristicInstanceValues() {
		return this.offerInstanceCharacterValues;
	}

	
	public void addBICharacteristicInstanceValue(OfferInstanceCharacterValue characteristicInstanceValue) {
		this.offerInstanceCharacterValues.add(characteristicInstanceValue);
		if (null==characteristicInstanceValue.getOfferInstanceCharacter()){
			characteristicInstanceValue.setOfferInstanceCharacter(this);
			super.addCharacteristicInstanceValue(characteristicInstanceValue);
		}

	}
}
