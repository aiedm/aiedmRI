package com.ai.crm.common.party.repository.interfaces;

import com.ai.crm.common.party.domain.model.interfaces.IIndividual;
import com.ai.crm.common.party.domain.model.interfaces.IOrganization;

public interface IPartyRepository {
	IIndividual saveIndividual(IIndividual party);
	IOrganization saveOrganization(IOrganization organization);
}
