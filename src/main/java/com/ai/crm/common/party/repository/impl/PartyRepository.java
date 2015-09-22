package com.ai.crm.common.party.repository.impl;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.ai.crm.common.party.domain.model.interfaces.IIndividual;
import com.ai.crm.common.party.domain.model.interfaces.IOrganization;
import com.ai.crm.common.party.repository.interfaces.IPartyRepository;

@Repository
public class PartyRepository implements IPartyRepository {
	//@Autowired
	SessionFactory sessionFactory;
	public PartyRepository(){
		
	}
	
	public PartyRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session currentSession() {
		return sessionFactory.openSession();
	}
	
	public IIndividual saveIndividual(IIndividual individual) {
		Serializable id = currentSession().save(individual);
		individual.setId((Long)id);
		return individual;
	}

	public IOrganization saveOrganization(IOrganization organization) {
		Serializable id = currentSession().save(organization);
		organization.setId((Long)id);
		return organization;
	}

}
