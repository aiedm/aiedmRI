package com.ai.crm.product.domain.model;

import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.ai.common.rootentity.domain.model.CharacteristicSpecValue;
import com.ai.common.rootentity.domain.model.SpecInstanceEntityCharacter;
import com.ai.common.rootentity.domain.model.SpecInstanceEntityCharacterValue;
@MappedSuperclass
public class ProductCharacterValue extends SpecInstanceEntityCharacterValue {
	@ManyToOne
	private  ProductCharacter  productCharacter;
	public ProductCharacterValue() {
	}

	public ProductCharacterValue(SpecInstanceEntityCharacter instanceEntityCharacteristic,
			CharacteristicSpecValue characteristicValue) {
		super(instanceEntityCharacteristic, characteristicValue);
	}

	public ProductCharacter getProductCharacter() {
		return productCharacter;
	}

	public void setProductCharacter(ProductCharacter productCharacter) {
		this.productCharacter = productCharacter;
	}

}
