package com.ai.crm.product.domain.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ai.common.rootentity.domain.model.SpecInstanceEntityCharacterValue;
@Entity
@Table(name="PD_OFFER_INS_CHARACTER")
public class AsIsOfferInstanceCharacter extends OfferInstanceCharacter {	
	@ManyToOne
	private AsIsOfferInstance offerInstance;
	@OneToMany(mappedBy="offerInstanceCharacter",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<AsIsOfferInstanceCharacterValue> offerInstanceCharacterValues=new LinkedHashSet<AsIsOfferInstanceCharacterValue>();

	public OfferInstance getOfferInstance() {
		return offerInstance;
	}
	public void setOfferInstance(AsIsOfferInstance offerInstance) {
		this.offerInstance = offerInstance;
	}
	public Set<AsIsOfferInstanceCharacterValue> getBICharacteristicInstanceValues() {
		return this.offerInstanceCharacterValues;
	}

	
	public void addBICharacteristicInstanceValue(AsIsOfferInstanceCharacterValue characteristicInstanceValue) {
		this.offerInstanceCharacterValues.add(characteristicInstanceValue);
		if (null==characteristicInstanceValue.getOfferInstanceCharacter()){
			characteristicInstanceValue.setOfferInstanceCharacter(this);
			super.addCharacteristicInstanceValue(characteristicInstanceValue);
		}

	}	
	@Override
	public SpecInstanceEntityCharacterValue  newCharacterValue(){
		return new AsIsOfferInstanceCharacterValue();
	}
	
}
