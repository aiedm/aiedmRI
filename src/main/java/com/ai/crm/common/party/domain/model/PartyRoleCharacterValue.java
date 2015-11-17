package com.ai.crm.common.party.domain.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.ai.common.rootentity.domain.model.CharacteristicSpecValue;
import com.ai.common.rootentity.domain.model.SpecInstanceEntityCharacter;
import com.ai.common.rootentity.domain.model.SpecInstanceEntityCharacterValue;
@Entity
public class PartyRoleCharacterValue extends SpecInstanceEntityCharacterValue {
	@ManyToOne
	private  PartyRoleCharacter  partyRoleCharacter;
	public PartyRoleCharacterValue() {
	}

	public PartyRoleCharacterValue(SpecInstanceEntityCharacter instanceEntityCharacteristic,
			CharacteristicSpecValue characteristicValue) {
		super(instanceEntityCharacteristic, characteristicValue);
	}

	public PartyRoleCharacter getPartyRoleCharacter() {
		return partyRoleCharacter;
	}

	public void setPartyRoleCharacter(PartyRoleCharacter partyRoleCharacter) {
		this.partyRoleCharacter = partyRoleCharacter;
	}

}
