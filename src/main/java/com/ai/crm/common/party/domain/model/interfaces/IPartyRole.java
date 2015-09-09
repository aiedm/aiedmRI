package com.ai.crm.common.party.domain.model.interfaces;

public interface IPartyRole {
	long getId();
	void setId(long id);
	IParty getParty();

	void setParty(IParty party);
	
	String getPartyRoleType() ;
	void setPartyRoleType(String partyRoleType);
}
