package com.ai.crm.customerorder.domain.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ai.common.rootentity.domain.model.CharacteristicSpecValue;
import com.ai.crm.product.domain.model.PricePlanInstanceCharacterValue;
@Entity
@Table(name="ORD_TOBE_PRICE_CHARACTER_VALUE")
public class ToBePricePlanInstanceCharacterValue extends PricePlanInstanceCharacterValue {
	@ManyToOne
	private ToBePricePlanInstanceCharacter pricePlanInstanceCharacter;
	public ToBePricePlanInstanceCharacterValue() {
	}

	public ToBePricePlanInstanceCharacterValue(ToBePricePlanInstanceCharacter instanceEntityCharacteristic,
			CharacteristicSpecValue characteristicValue) {
		super(instanceEntityCharacteristic, characteristicValue);
	}

	public ToBePricePlanInstanceCharacter getPricePlanInstanceCharacter() {
		return pricePlanInstanceCharacter;
	}

	public void setPricePlanInstanceCharacter(ToBePricePlanInstanceCharacter pricePlanInstanceCharacter) {
		this.pricePlanInstanceCharacter = pricePlanInstanceCharacter;
	}

}
