package com.ai.crm.common.party.domain.model.impl;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;

import com.ai.crm.common.party.domain.model.interfaces.IIndividual;

@Entity
@SecondaryTable(
	    name = "INDIVIDUAL",
	    pkJoinColumns = @PrimaryKeyJoinColumn(name = "INDIVIDUAL_ID")
	)
@DiscriminatorValue("Individual")
public class Individual extends Party implements IIndividual {
	private Individual(){}
	
	@Basic
	@Column(table="INDIVIDUAL")
	private String firstName;
	
	@Basic
	@Column(table="INDIVIDUAL")
	private String lastName;
	
	public Individual(String firstName,String lastName){
		this.firstName=firstName;
		this.lastName=lastName;
		super.setPartyType("Individual");
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String getName() {
		return this.firstName+" "+this.lastName;
	}

}
