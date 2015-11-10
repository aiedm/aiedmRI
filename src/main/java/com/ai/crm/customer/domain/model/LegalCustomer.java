package com.ai.crm.customer.domain.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.ai.crm.common.party.domain.model.LegalOrganization;

@Entity
@DiscriminatorValue("Customer.Legal")
public class LegalCustomer extends Customer{
	
	private LegalCustomer(){
		
	}
	
	public LegalCustomer(LegalOrganization legalOrganization){
		super(legalOrganization);
	}
	
	public LegalOrganization getLegalOrganization() {
		return (LegalOrganization)super.getParty();
	}

}
