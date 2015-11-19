package com.ai.crm.common.party.domain.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ai.common.rootentity.domain.model.SpecInstanceEntityCharacter;

@Entity
@Table(name="PT_PARTY_CHARACTER")
public class PartyCharacter extends SpecInstanceEntityCharacter {
	@ManyToOne
	private Party party;
	@OneToMany(mappedBy="partyCharacter")
	private Set<PartyCharacterValue> partyCharacterValues=new LinkedHashSet<PartyCharacterValue>();

	public PartyCharacter() {
	}
	public Party getParty() {
		return party;
	}
	public void setParty(Party party) {
		this.party = party;
	}
	public Set<PartyCharacterValue> getPartyCharacterValues() {
		return this.partyCharacterValues;
	}

	
	public void addPartyCharacterValue(PartyCharacterValue characteristicInstanceValue) {
		this.partyCharacterValues.add(characteristicInstanceValue);
		if (null==characteristicInstanceValue.getPartyCharacter()){
			characteristicInstanceValue.setPartyCharacter(this);
			super.addCharacteristicInstanceValue(characteristicInstanceValue);
		}

	}
}
