package com.ai.crm.customerorder.domain.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ai.common.rootentity.domain.model.SpecInstanceEntityCharacterValue;
import com.ai.crm.product.domain.model.OfferInstance;
import com.ai.crm.product.domain.model.OfferInstanceCharacter;
@Entity
@Table(name="ORD_TOBE_OFFER_INS_CHARACTER")
public class ToBeOfferInstanceCharacter extends OfferInstanceCharacter {
	@ManyToOne
	private ToBeOfferInstance offerInstance;
	@OneToMany(mappedBy="offerInstanceCharacter",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<ToBeOfferInstanceCharacterValue> offerInstanceCharacterValues=new LinkedHashSet<ToBeOfferInstanceCharacterValue>();

	public OfferInstance getOfferInstance() {
		return offerInstance;
	}
	public void setOfferInstance(ToBeOfferInstance offerInstance) {
		this.offerInstance = offerInstance;
	}
	public Set<ToBeOfferInstanceCharacterValue> getBICharacteristicInstanceValues() {
		return this.offerInstanceCharacterValues;
	}

	
	public void addBICharacteristicInstanceValue(ToBeOfferInstanceCharacterValue characteristicInstanceValue) {
		this.offerInstanceCharacterValues.add(characteristicInstanceValue);
		if (null==characteristicInstanceValue.getOfferInstanceCharacter()){
			characteristicInstanceValue.setOfferInstanceCharacter(this);
			super.addCharacteristicInstanceValue(characteristicInstanceValue);
		}

	}	
	@Override
	public SpecInstanceEntityCharacterValue  newCharacterValue(){
		return new ToBeOfferInstanceCharacterValue();
	}
}
