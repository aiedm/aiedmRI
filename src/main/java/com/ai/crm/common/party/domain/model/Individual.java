package com.ai.crm.common.party.domain.model;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Individual")
public class Individual extends Party{
	private Individual(){}
	
	private String firstName;
	
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
