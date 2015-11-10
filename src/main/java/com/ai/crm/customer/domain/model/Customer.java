package com.ai.crm.customer.domain.model;


import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;

import com.ai.crm.common.party.domain.model.Individual;
import com.ai.crm.common.party.domain.model.Party;
import com.ai.crm.common.party.domain.model.PartyRole;

@Entity
//@PrimaryKeyJoinColumn(name="CUST_ID")
@SecondaryTable(
	    name = "CUSTOMER",
	    pkJoinColumns = @PrimaryKeyJoinColumn(name = "CUST_ID")
	)
@DiscriminatorValue("Customer")
public abstract class Customer  extends PartyRole{
	
	@Basic
	@Column(table="CUSTOMER")
	private boolean isIndividual;
	@Basic
	@Column(table="CUSTOMER")
	private String customerName;
	
	public Customer(){

	}

	public Customer(Party party) {
		super(party);
		if (party instanceof Individual){
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
