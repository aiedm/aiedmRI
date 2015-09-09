package com.ai.crm.common.party.domain.model.impl;

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
import javax.persistence.Transient;

import com.ai.crm.common.party.domain.model.interfaces.IParty;
import com.ai.crm.common.party.domain.model.interfaces.IPartyRole;
@Entity
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="partyRoleType",discriminatorType=DiscriminatorType.STRING)
public abstract class PartyRole implements IPartyRole {
	
	public PartyRole(){}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	@Column(insertable = false, updatable = false)
	String partyRoleType;
	
	public String getPartyRoleType() {
		return partyRoleType;
	}

	public void setPartyRoleType(String partyRoleType) {
		this.partyRoleType = partyRoleType;
	}
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name="PARTY_ID")//加入一列作为外键
	private Party party;	
	
	public PartyRole(IParty party){
		this.party=(Party)party;
	}
	
	public IParty getParty() {		
		return party;
	}

	public void setParty(IParty party) {
		this.party =(Party) party;
	}
}