package com.ai.crm.customer.domain.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.ai.crm.common.party.domain.model.Individual;
@Entity
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
