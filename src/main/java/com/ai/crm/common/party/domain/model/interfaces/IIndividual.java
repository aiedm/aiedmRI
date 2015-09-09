package com.ai.crm.common.party.domain.model.interfaces;

public interface IIndividual extends IParty{
	String getFirstName();
	void setFirstName(String firstName);
	String getLastName();
	void setLastName(String lastName);
	String getName();
}
