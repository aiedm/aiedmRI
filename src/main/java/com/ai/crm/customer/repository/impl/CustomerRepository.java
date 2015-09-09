package com.ai.crm.customer.repository.impl;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.ai.crm.customer.domain.model.impl.IndividualCustomer;
import com.ai.crm.customer.domain.model.impl.LegalCustomer;
import com.ai.crm.customer.domain.model.interfaces.IIndividualCustomer;
import com.ai.crm.customer.domain.model.interfaces.ILegalCustomer;
import com.ai.crm.customer.repository.interfaces.ICustomerRepository;

@Repository
public class CustomerRepository implements ICustomerRepository {
	//@Autowired
	SessionFactory sessionFactory;
	public CustomerRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session currentSession() {
		return sessionFactory.openSession();
	}
	
	public IIndividualCustomer saveIndividualCustomer(IIndividualCustomer individualCustomer) {
		Serializable id = currentSession().save(individualCustomer);
		individualCustomer.setId((Long)id);
		return individualCustomer;
	}
	public ILegalCustomer saveLegalCustomer(ILegalCustomer legalCustomer) {		
		Serializable id = currentSession().save(legalCustomer);
		legalCustomer.setId((Long)id);
		return legalCustomer;
	}
	
	public IIndividualCustomer findIndividualCustomer(long customerId){
		IIndividualCustomer individualCustomer=(IIndividualCustomer)currentSession().get(IndividualCustomer.class, customerId);
		return individualCustomer;
	}

	public ILegalCustomer findLegalCustomer(long customerId){
		LegalCustomer legalCustomer=(LegalCustomer)currentSession().get(LegalCustomer.class, customerId);
		return legalCustomer;
	}
}
