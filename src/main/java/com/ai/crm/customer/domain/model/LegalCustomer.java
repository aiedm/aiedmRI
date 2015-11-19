package com.ai.crm.customer.domain.model;

import javax.persistence.DiscriminatorValue;

import com.ai.crm.common.party.domain.model.LegalOrganization;

@DiscriminatorValue("CUSTOMER.LEGAL")
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
