package com.ai.crm.customerorder.domain.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ai.common.rootentity.domain.model.CharacteristicSpecValue;
import com.ai.crm.product.domain.model.ProductCharacterValue;
@Entity
@Table(name="ORD_TOBE_PRODUCT_CHARACTER_VALUE")
public class ToBeProductCharacterValue extends ProductCharacterValue {
	@ManyToOne
	private  ToBeProductCharacter  productCharacter;
	public ToBeProductCharacterValue() {
	}

	public ToBeProductCharacterValue(ToBeProductCharacter instanceEntityCharacteristic,
			CharacteristicSpecValue characteristicValue) {
		super(instanceEntityCharacteristic, characteristicValue);
	}

	public ToBeProductCharacter getProductCharacter() {
		return productCharacter;
	}

	public void setProductCharacter(ToBeProductCharacter productCharacter) {
		this.productCharacter = productCharacter;
	}
}
