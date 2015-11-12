package com.ai.crm.common.party.domain.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ai.common.rootentity.domain.model.SpecInstanceEntity;
@Entity
@Table(name="CB_PARTY_ROLE")
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="partyRoleType",discriminatorType=DiscriminatorType.STRING)
public abstract class PartyRole extends SpecInstanceEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;	
	public PartyRole(){}
	
	
	@Column(insertable = false, updatable = false)
	String partyRoleType;
	
	public String getPartyRoleType() {
		return partyRoleType;
	}

	public void setPartyRoleType(String partyRoleType) {
		this.partyRoleType = partyRoleType;
	}
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name="PARTY_ID")
	private Party party;	
	
	public PartyRole(Party party){
		this.party=(Party)party;
	}
	
	public Party getParty() {		
		return party;
	}

	public void setParty(Party party) {
		this.party =(Party) party;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
