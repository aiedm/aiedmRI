package com.ai.crm.common.party.domain.model;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;

@Entity
@DiscriminatorValue("INDIVIDUAL")
@SecondaryTable(
	    name = "PT_INDIVIDUAL",
	    pkJoinColumns = @PrimaryKeyJoinColumn(name = "INDIVIDUAL_ID")
)
public class Individual extends Party{
	private Individual(){}
	@Column(table="PT_INDIVIDUAL",name="FIRST_NAME")
	private String firstName;
	@Column(table="PT_INDIVIDUAL",name="LAST_NAME")
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
