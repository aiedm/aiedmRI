package com.ai.crm.customer.domain.model.impl;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

import com.ai.crm.common.party.domain.model.interfaces.IIndividual;
import com.ai.crm.customer.domain.model.interfaces.IIndividualCustomer;
@Entity
@DiscriminatorValue("Customer.Individual")
public class IndividualCustomer extends Customer implements IIndividualCustomer {
	private IndividualCustomer(){

	}
	
	public IndividualCustomer(IIndividual individual){
		super(individual);
	}

	public IIndividual getIndividual() {
		return (IIndividual)super.getParty();
	}

}
