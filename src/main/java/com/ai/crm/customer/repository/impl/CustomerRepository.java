package com.ai.crm.customer.repository.impl;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.ai.crm.customer.domain.model.IndividualCustomer;
import com.ai.crm.customer.domain.model.LegalCustomer;
import com.ai.crm.customer.repository.interfaces.ICustomerRepository;

@Repository
public class CustomerRepository implements ICustomerRepository {
	//@Autowired
	SessionFactory sessionFactory;
	
	public CustomerRepository() {
		
	}

	
	public CustomerRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session currentSession() {
		return sessionFactory.openSession();
	}
	
	public IndividualCustomer saveIndividualCustomer(IndividualCustomer individualCustomer) {
		Serializable id = currentSession().save(individualCustomer);
		individualCustomer.setId((Long)id);
		return individualCustomer;
	}
	public LegalCustomer saveLegalCustomer(LegalCustomer legalCustomer) {		
		Serializable id = currentSession().save(legalCustomer);
		legalCustomer.setId((Long)id);
		return legalCustomer;
	}
	
	public IndividualCustomer findIndividualCustomer(long customerId){
		IndividualCustomer individualCustomer=(IndividualCustomer)currentSession().get(IndividualCustomer.class, customerId);
		return individualCustomer;
	}

	public LegalCustomer findLegalCustomer(long customerId){
		LegalCustomer legalCustomer=(LegalCustomer)currentSession().get(LegalCustomer.class, customerId);
		return legalCustomer;
	}
}
