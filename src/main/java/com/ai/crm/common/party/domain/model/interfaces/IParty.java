package com.ai.crm.common.party.domain.model.interfaces;

import java.util.Set;

import com.ai.crm.common.party.domain.model.impl.PartyRole;

public interface IParty {
	String getName();
	long getId();
	void setId(long id);	
	Set<PartyRole> getPartyRoles();
	void addPartyRole(PartyRole partyRole);
	String getPartyType();
	void setPartyType(String partyType);
	void setPartyType2(String partyType);
}
