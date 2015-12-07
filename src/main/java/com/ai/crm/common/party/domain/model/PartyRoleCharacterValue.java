package com.ai.crm.common.party.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ai.common.rootentity.domain.model.SpecInstanceEntityCharacterValue;
@Entity
@Table(name="PT_PARTY_ROLE_CHARACTER_VALUE")
public class PartyRoleCharacterValue extends SpecInstanceEntityCharacterValue {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}	
	@ManyToOne
	private  PartyRoleCharacter  partyRoleCharacter;
	public PartyRoleCharacterValue() {
	}

	public PartyRoleCharacter getPartyRoleCharacter() {
		return partyRoleCharacter;
	}

	public void setPartyRoleCharacter(PartyRoleCharacter partyRoleCharacter) {
		this.partyRoleCharacter = partyRoleCharacter;
	}

}
