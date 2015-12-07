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
import com.ai.crm.product.domain.model.PricePlanInstanceCharacter;
@Entity
@Table(name="ORD_TOBE_PRICE_CHARACTER")
public class ToBePricePlanInstanceCharacter extends PricePlanInstanceCharacter {
	@ManyToOne
	private ToBePricePlanInstance pricePlanInstance;
	@OneToMany(mappedBy="pricePlanInstanceCharacter",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<ToBePricePlanInstanceCharacterValue> pricePlanInstanceCharacterValues=new LinkedHashSet<ToBePricePlanInstanceCharacterValue>();

	public ToBePricePlanInstanceCharacter() {
	}
	public ToBePricePlanInstance getPricePlanInstance() {
		return pricePlanInstance;
	}
	public void setPricePlanInstance(ToBePricePlanInstance pricePlanInstance) {
		this.pricePlanInstance = pricePlanInstance;
	}
	public Set<ToBePricePlanInstanceCharacterValue> getPricePlanInstanceCharacterValues() {
		return this.pricePlanInstanceCharacterValues;
	}

	
	public void addPricePlanInstanceCharacterValue(ToBePricePlanInstanceCharacterValue characteristicInstanceValue) {
		this.pricePlanInstanceCharacterValues.add(characteristicInstanceValue);
		super.addCharacteristicInstanceValue(characteristicInstanceValue);
		if (null==characteristicInstanceValue.getPricePlanInstanceCharacter()){
			characteristicInstanceValue.setPricePlanInstanceCharacter(this);			
		}

	}
	
	@Override
	public SpecInstanceEntityCharacterValue  newCharacterValue(){
		return new ToBePricePlanInstanceCharacterValue();
	}
	
	@Override
	public void addInstanceEntityCharacterValue(SpecInstanceEntityCharacterValue characteristicInstanceValue) {
		this.addPricePlanInstanceCharacterValue((ToBePricePlanInstanceCharacterValue)characteristicInstanceValue);		
	}
}
