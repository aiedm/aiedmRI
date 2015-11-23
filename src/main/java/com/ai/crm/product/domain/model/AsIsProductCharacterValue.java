package com.ai.crm.product.domain.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ai.common.rootentity.domain.model.CharacteristicSpecValue;
@Entity
@Table(name="PD_PRODUCT_CHARACTER_VALUE")
public class AsIsProductCharacterValue extends ProductCharacterValue {
	@ManyToOne
	private  AsIsProductCharacter  productCharacter;
	public AsIsProductCharacterValue() {
	}

	public AsIsProductCharacterValue(AsIsProductCharacter instanceEntityCharacteristic,
			CharacteristicSpecValue characteristicValue) {
		super(instanceEntityCharacteristic, characteristicValue);
	}

	public AsIsProductCharacter getProductCharacter() {
		return productCharacter;
	}

	public void setProductCharacter(AsIsProductCharacter productCharacter) {
		this.productCharacter = productCharacter;
	}
}
