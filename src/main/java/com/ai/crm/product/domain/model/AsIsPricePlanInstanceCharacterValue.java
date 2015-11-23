package com.ai.crm.product.domain.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ai.common.rootentity.domain.model.CharacteristicSpecValue;
@Entity
@Table(name="PD_PRICE_CHARACTER_VALUE")
public class AsIsPricePlanInstanceCharacterValue extends PricePlanInstanceCharacterValue {
	@ManyToOne
	private AsIsPricePlanInstanceCharacter pricePlanInstanceCharacter;
	public AsIsPricePlanInstanceCharacterValue() {
	}

	public AsIsPricePlanInstanceCharacterValue(AsIsPricePlanInstanceCharacter instanceEntityCharacteristic,
			CharacteristicSpecValue characteristicValue) {
		super(instanceEntityCharacteristic, characteristicValue);
	}

	public AsIsPricePlanInstanceCharacter getPricePlanInstanceCharacter() {
		return pricePlanInstanceCharacter;
	}

	public void setPricePlanInstanceCharacter(AsIsPricePlanInstanceCharacter pricePlanInstanceCharacter) {
		this.pricePlanInstanceCharacter = pricePlanInstanceCharacter;
	}

}
