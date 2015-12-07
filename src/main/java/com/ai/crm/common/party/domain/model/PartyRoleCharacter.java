package com.ai.crm.common.party.domain.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ai.common.rootentity.domain.model.SpecInstanceEntityCharacter;
import com.ai.common.rootentity.domain.model.SpecInstanceEntityCharacterValue;

@Entity
@Table(name="PT_PARTY_ROLE_CHARACTER")
public class PartyRoleCharacter extends SpecInstanceEntityCharacter {
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
	
	@Override
	public SpecInstanceEntityCharacterValue  newCharacterValue(){
		return new PartyRoleCharacterValue();
	}
	
	@Override
	public void addInstanceEntityCharacterValue(SpecInstanceEntityCharacterValue characteristicInstanceValue) {
		this.addPartyRoleCharacterValue((PartyRoleCharacterValue)characteristicInstanceValue);		
	}
}
