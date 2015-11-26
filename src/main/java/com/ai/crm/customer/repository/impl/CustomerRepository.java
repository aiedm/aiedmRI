package com.ai.crm.customer.repository.impl;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ai.crm.customer.domain.model.IndividualCustomer;
import com.ai.crm.customer.domain.model.LegalCustomer;
import com.ai.crm.customer.repository.interfaces.ICustomerRepository;

@Repository
@Transactional
public class CustomerRepository implements ICustomerRepository {
	@Autowired
	SessionFactory sessionFactory;
	
	public CustomerRepository() {
		
	}

	
	public CustomerRepository(SessionFactory sessionFactory) throws Exception{
		this.sessionFactory = sessionFactory;
	}

	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public IndividualCustomer saveIndividualCustomer(IndividualCustomer individualCustomer) throws Exception {
		Serializable id = currentSession().save(individualCustomer);
		individualCustomer.setId((Long)id);
		currentSession().flush();
		return individualCustomer;
	}
	public LegalCustomer saveLegalCustomer(LegalCustomer legalCustomer) throws Exception{		
		Serializable id = currentSession().save(legalCustomer);
		legalCustomer.setId((Long)id);
		return legalCustomer;
	}
	
	public IndividualCustomer findIndividualCustomer(long customerId) throws Exception{
		IndividualCustomer individualCustomer=(IndividualCustomer)currentSession().get(IndividualCustomer.class, customerId);
		return individualCustomer;
	}

	public LegalCustomer findLegalCustomer(long customerId) throws Exception{
		LegalCustomer legalCustomer=(LegalCustomer)currentSession().get(LegalCustomer.class, customerId);
		return legalCustomer;
	}
}
