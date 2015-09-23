package com.ai.crm.common.party.domain.model.interfaces;

import com.ai.crm.common.rootentity.interfaces.IRootEntity;

public interface IPartyRole extends IRootEntity{
	long getId();
	void setId(long id);
	IParty getParty();

	void setParty(IParty party);
	
	String getPartyRoleType() ;
	void setPartyRoleType(String partyRoleType);
}
