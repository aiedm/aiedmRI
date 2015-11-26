package com.ai.crm.common.party.repository.impl;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ai.crm.common.party.domain.model.Individual;
import com.ai.crm.common.party.domain.model.Organization;
import com.ai.crm.common.party.repository.interfaces.IPartyRepository;

@Repository
public class PartyRepository implements IPartyRepository {
	@Autowired
	SessionFactory sessionFactory;
	public PartyRepository(){
		
	}
	
	public PartyRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session currentSession() {
		return sessionFactory.getCurrentSession();
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
