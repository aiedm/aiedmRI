package com.ai.crm.common.businessinteraction.domain.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.ai.common.rootentity.domain.model.CharacteristicSpecValue;
import com.ai.common.rootentity.domain.model.SpecInstanceEntityCharacter;
import com.ai.common.rootentity.domain.model.SpecInstanceEntityCharacterValue;
@Entity
public class BIICharacterValue extends SpecInstanceEntityCharacterValue {
	@ManyToOne
	private BIICharacter biiCharacter;
	public BIICharacterValue() {
	}

	public BIICharacterValue(SpecInstanceEntityCharacter instanceEntityCharacteristic, CharacteristicSpecValue characteristicValue) {
		super(instanceEntityCharacteristic, characteristicValue);
	}

	public BIICharacter getBiiCharacter() {
		return biiCharacter;
	}

	public void setBiiCharacter(BIICharacter biCharacter) {
		this.biiCharacter = biCharacter;
	}

}
