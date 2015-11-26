package com.ai.crm.common.party.domain.model;
import java.util.LinkedHashSet;
import java.util.Set;

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
import javax.persistence.Table;

import com.ai.common.rootentity.domain.model.SpecInstanceEntity;
@Entity
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="PARTY_TYPE",discriminatorType=DiscriminatorType.STRING)
@Table(name="PT_PARTY")
public abstract class Party extends SpecInstanceEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name="ID",insertable = false, updatable = false)
	private long id;
	@Column(insertable = false, updatable = false,name="PARTY_TYPE")
	private String partyType;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="party")
	private Set<PartyRole> partyRoles; 
	
	@OneToMany(mappedBy="party",fetch=FetchType.LAZY)
	private Set<PartyCharacter> characterInstances=new LinkedHashSet<PartyCharacter>();
	
	public  Set<PartyCharacter> getPartyCharacteristics(){
		return this.characterInstances;
	}
	
	public void addPartyCharacteristic(PartyCharacter character){
		if(null!=character){
			this.characterInstances.add(character);
			super.addCharacteristic(character);
		}
	}
	
	public Party(){}
		
	public String getPartyType() {
		return partyType;
	}
	public void setPartyType(String partyType) {
		this.partyType = partyType;
	}
	
	
	public Set<PartyRole> getPartyRoles() {
		return partyRoles;
	}
	public void addPartyRole(PartyRole partyRole) {
		this.partyRoles.add(partyRole);
	}

	abstract public String getName();
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

}
