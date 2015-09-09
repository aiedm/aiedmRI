package com.ai.crm.customer.domain.model.impl;


import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;

import com.ai.crm.common.party.domain.model.impl.PartyRole;
import com.ai.crm.common.party.domain.model.interfaces.IIndividual;
import com.ai.crm.common.party.domain.model.interfaces.IParty;
import com.ai.crm.customer.domain.model.interfaces.ICustomer;

@Entity
//@PrimaryKeyJoinColumn(name="CUST_ID")
@SecondaryTable(
	    name = "CUSTOMER",
	    pkJoinColumns = @PrimaryKeyJoinColumn(name = "CUST_ID")
	)
@DiscriminatorValue("Customer")
public abstract class Customer  extends PartyRole implements ICustomer{
	
	@Basic
	@Column(table="CUSTOMER")
	private boolean isIndividual;
	@Basic
	@Column(table="CUSTOMER")
	private String customerName;
	
	public Customer(){

	}

	public Customer(IParty party) {
		super(party);
		if (party instanceof IIndividual){
			isIndividual=true;
			super.setPartyRoleType("Customer.Individual");
		}else{
			isIndividual=false;
			super.setPartyRoleType("Customer.Legal");
		}
		customerName= super.getParty().getName();
	}
	
	public boolean isIndividualCustomer(){
		return  isIndividual;
	}

	public String getCustomerName() {
		return customerName;
	}
}
