package com.ai.crm.common.party.domain.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.ai.common.rootentity.domain.model.SpecInstanceEntityCharacter;

@Entity
public class PartyRoleCharacter extends SpecInstanceEntityCharacter {
	@ManyToOne
	private PartyRole partyRole;
	@OneToMany(mappedBy="partyRoleCharacter")
	private Set<PartyRoleCharacterValue> partyRoleCharacterValues=new LinkedHashSet<PartyRoleCharacterValue>();

	public PartyRoleCharacter() {
	}
	public PartyRole getPartyRole() {
		return partyRole;
	}
	public void setPartyRole(PartyRole partyRole) {
		this.partyRole = partyRole;
	}
	public Set<PartyRoleCharacterValue> getPartyRoleCharacterValues() {
		return this.partyRoleCharacterValues;
	}

	
	public void addPartyRoleCharacterValue(PartyRoleCharacterValue characteristicInstanceValue) {
		this.partyRoleCharacterValues.add(characteristicInstanceValue);
		if (null==characteristicInstanceValue.getPartyRoleCharacter()){
			characteristicInstanceValue.setPartyRoleCharacter(this);
			super.addCharacteristicInstanceValue(characteristicInstanceValue);
		}

	}
}
