package com.ai.crm.common.party.domain.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.ai.common.rootentity.domain.model.CharacteristicSpecValue;
import com.ai.common.rootentity.domain.model.SpecInstanceEntityCharacter;
import com.ai.common.rootentity.domain.model.SpecInstanceEntityCharacterValue;
@Entity
public class PartyCharacterValue extends SpecInstanceEntityCharacterValue {
	@ManyToOne
	private  PartyCharacter  partyCharacter;
	public PartyCharacterValue() {
	}

	public PartyCharacterValue(SpecInstanceEntityCharacter instanceEntityCharacteristic,
			CharacteristicSpecValue characteristicValue) {
		super(instanceEntityCharacteristic, characteristicValue);
	}

	public PartyCharacter getPartyCharacter() {
		return partyCharacter;
	}

	public void setPartyCharacter(PartyCharacter partyCharacter) {
		this.partyCharacter = partyCharacter;
	}

}
