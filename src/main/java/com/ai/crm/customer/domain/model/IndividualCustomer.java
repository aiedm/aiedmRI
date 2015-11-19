package com.ai.crm.customer.domain.model;

import javax.persistence.DiscriminatorValue;

import com.ai.crm.common.party.domain.model.Individual;
@DiscriminatorValue("CUSRTOMER.INDIVIDUAL")
public class IndividualCustomer extends Customer {
	private IndividualCustomer(){

	}
	
	public IndividualCustomer(Individual individual){
		super(individual);
	}

	public Individual getIndividual() {
		return (Individual)super.getParty();
	}

}
