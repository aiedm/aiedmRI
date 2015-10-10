package com.ai.crm.common.party.domain.model.impl;
import java.util.Set;

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
import javax.persistence.OneToMany;

import com.ai.common.rootentity.domain.model.impl.InstanceEntity;
import com.ai.common.rootentity.domain.model.impl.RootEntity;
import com.ai.crm.common.party.domain.model.interfaces.IParty;
@Entity
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="partyType",discriminatorType=DiscriminatorType.STRING)
public abstract class Party extends InstanceEntity implements IParty {
	public Party(){}
	
	@Override
	public boolean hasCharacteristic() {
		return true;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(insertable = false, updatable = false)
	private String partyType;
	
	public String getPartyType() {
		return partyType;
	}
	public void setPartyType(String partyType) {
		this.partyType = partyType;
	}
	@OneToMany(fetch=FetchType.LAZY,mappedBy="party")
	private Set<PartyRole> partyRoles; 
	
	public Set<PartyRole> getPartyRoles() {
		return partyRoles;
	}
	public void addPartyRole(PartyRole partyRole) {
		this.partyRoles.add(partyRole);
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	abstract public String getName();

}
