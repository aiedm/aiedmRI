package com.ai.crm.common.party.repository.interfaces;

import com.ai.crm.common.party.domain.model.Individual;
import com.ai.crm.common.party.domain.model.Organization;


public interface IPartyRepository {
	Individual saveIndividual(Individual party);
	Individual findIndividualById(long individualID);
	Organization saveOrganization(Organization organization);
}
