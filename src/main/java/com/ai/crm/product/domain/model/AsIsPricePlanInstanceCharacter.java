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
@Table(name="PD_PRICE_CHARACTER")
public class AsIsPricePlanInstanceCharacter extends PricePlanInstanceCharacter {
	@ManyToOne
	private AsIsPricePlanInstance pricePlanInstance;
	@OneToMany(mappedBy="pricePlanInstanceCharacter",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<AsIsPricePlanInstanceCharacterValue> pricePlanInstanceCharacterValues=new LinkedHashSet<AsIsPricePlanInstanceCharacterValue>();

	public AsIsPricePlanInstanceCharacter() {
	}
	public AsIsPricePlanInstance getPricePlanInstance() {
		return pricePlanInstance;
	}
	public void setPricePlanInstance(AsIsPricePlanInstance pricePlanInstance) {
		this.pricePlanInstance = pricePlanInstance;
	}
	public Set<AsIsPricePlanInstanceCharacterValue> getPricePlanInstanceCharacterValues() {
		return this.pricePlanInstanceCharacterValues;
	}

	
	public void addPricePlanInstanceCharacterValueValue(AsIsPricePlanInstanceCharacterValue characteristicInstanceValue) {
		this.pricePlanInstanceCharacterValues.add(characteristicInstanceValue);
		if (null==characteristicInstanceValue.getPricePlanInstanceCharacter()){
			characteristicInstanceValue.setPricePlanInstanceCharacter(this);
			super.addCharacteristicInstanceValue(characteristicInstanceValue);
		}

	}
	
	@Override
	public SpecInstanceEntityCharacterValue  newCharacterValue(){
		return new AsIsPricePlanInstanceCharacterValue();
	}
	
	@Override
	public void addInstanceEntityCharacterValue(SpecInstanceEntityCharacterValue characteristicInstanceValue) {
		this.addPricePlanInstanceCharacterValueValue((AsIsPricePlanInstanceCharacterValue)characteristicInstanceValue);		
	}
}
