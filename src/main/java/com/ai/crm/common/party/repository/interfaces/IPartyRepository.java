package com.ai.crm.common.party.repository.interfaces;

import com.ai.crm.common.party.domain.model.Individual;
import com.ai.crm.common.party.domain.model.Organization;


public interface IPartyRepository {
	Individual saveIndividual(Individual party);
	Organization saveOrganization(Organization organization);
}
