package com.ai.crm.common.party.repository.impl;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.ai.common.rootentity.domain.repository.impl.BaseRepository;
import com.ai.crm.common.party.domain.model.Individual;
import com.ai.crm.common.party.domain.model.Organization;
import com.ai.crm.common.party.repository.interfaces.IPartyRepository;

@Repository
public class PartyRepository extends BaseRepository implements IPartyRepository {
	public PartyRepository(){
		
	}
	
	public PartyRepository(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
	
	public Individual saveIndividual(Individual individual) {
		Serializable id = currentSession().save(individual);
		individual.setId((Long)id);
		return individual;
	}

	public Organization saveOrganization(Organization organization) {
		Serializable id = currentSession().save(organization);
		organization.setId((Long)id);
		return organization;
	}

	@Override
	public Individual findIndividualById(long individualID) {
		return (Individual)currentSession().get(Individual.class, individualID);
	}

}
