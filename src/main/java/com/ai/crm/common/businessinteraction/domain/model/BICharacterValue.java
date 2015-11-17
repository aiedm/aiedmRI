package com.ai.crm.common.businessinteraction.domain.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.ai.common.rootentity.domain.model.CharacteristicSpecValue;
import com.ai.common.rootentity.domain.model.SpecInstanceEntityCharacter;
import com.ai.common.rootentity.domain.model.SpecInstanceEntityCharacterValue;
@Entity
public class BICharacterValue extends SpecInstanceEntityCharacterValue {
	@ManyToOne
	private BICharacter biCharacter;
	public BICharacterValue() {
	}

	public BICharacterValue(SpecInstanceEntityCharacter instanceEntityCharacteristic, CharacteristicSpecValue characteristicValue) {
		super(instanceEntityCharacteristic, characteristicValue);
	}

	public BICharacter getBiCharacter() {
		return biCharacter;
	}

	public void setBiCharacter(BICharacter biCharacter) {
		this.biCharacter = biCharacter;
	}

}
