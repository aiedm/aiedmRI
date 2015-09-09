package com.ai.crm.customer.domain.model.impl;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

import com.ai.crm.common.party.domain.model.interfaces.ILegalOrganization;
import com.ai.crm.customer.domain.model.interfaces.ILegalCustomer;
@Entity
@DiscriminatorValue("Customer.Legal")
public class LegalCustomer extends Customer implements ILegalCustomer {
	
	private LegalCustomer(){
		
	}
	
	public LegalCustomer(ILegalOrganization legalOrganization){
		super(legalOrganization);
	}
	
	public ILegalOrganization getLegalOrganization() {
		return (ILegalOrganization)super.getParty();
	}

}
