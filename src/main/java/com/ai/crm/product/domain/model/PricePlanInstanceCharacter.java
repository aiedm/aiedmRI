package com.ai.crm.product.domain.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

import com.ai.common.rootentity.domain.model.SpecInstanceEntityCharacter;
import com.ai.common.rootentity.domain.model.SpecInstanceEntityCharacterValue;
import com.ai.crm.common.party.domain.model.PartyRoleCharacterValue;
@MappedSuperclass
public class PricePlanInstanceCharacter extends SpecInstanceEntityCharacter {
	@ManyToOne
	private PricePlanInstance pricePlanInstance;
	@OneToMany(mappedBy="pricePlanInstanceCharacter")
	private Set<PricePlanInstanceCharacterValue> pricePlanInstanceCharacterValues=new LinkedHashSet<PricePlanInstanceCharacterValue>();

	public PricePlanInstanceCharacter() {
	}
	public PricePlanInstance getPricePlanInstance() {
		return pricePlanInstance;
	}
	public void setPricePlanInstance(PricePlanInstance pricePlanInstance) {
		this.pricePlanInstance = pricePlanInstance;
	}
	public Set<PricePlanInstanceCharacterValue> getPricePlanInstanceCharacterValues() {
		return this.pricePlanInstanceCharacterValues;
	}

	
	public void addPricePlanInstanceCharacterValueValue(PricePlanInstanceCharacterValue characteristicInstanceValue) {
		this.pricePlanInstanceCharacterValues.add(characteristicInstanceValue);
		if (null==characteristicInstanceValue.getPricePlanInstanceCharacter()){
			characteristicInstanceValue.setPricePlanInstanceCharacter(this);
			super.addCharacteristicInstanceValue(characteristicInstanceValue);
		}

	}
	
	@Override
	public SpecInstanceEntityCharacterValue  newCharacterValue(){
		return new PricePlanInstanceCharacterValue();
	}
}
