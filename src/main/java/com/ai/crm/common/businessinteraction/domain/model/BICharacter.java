package com.ai.crm.common.businessinteraction.domain.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ai.common.rootentity.domain.model.SpecInstanceEntityCharacter;
import com.ai.common.rootentity.domain.model.SpecInstanceEntityCharacterValue;
@Entity
@Table(name="BI_CHARACTER")
public class BICharacter extends SpecInstanceEntityCharacter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private BusinessInteraction businessInteraction;
	@OneToMany(mappedBy="biCharacter",fetch=FetchType.LAZY)
	private Set<BICharacterValue> biCharacterValues=new LinkedHashSet<BICharacterValue>();
	public BICharacter() {
	}
	public BusinessInteraction getBusinessInteraction() {
		return businessInteraction;
	}
	public void setBusinessInteraction(BusinessInteraction businessInteraction) {
		this.businessInteraction = businessInteraction;
	}
	
	public Set<BICharacterValue> getBICharacteristicInstanceValues() {
		return this.biCharacterValues;
	}

	
	public void addBICharacteristicInstanceValue(BICharacterValue characteristicInstanceValue) {
		this.biCharacterValues.add(characteristicInstanceValue);
		if (null==characteristicInstanceValue.getBiCharacter()){
			characteristicInstanceValue.setBiCharacter(this);
			super.addCharacteristicInstanceValue(characteristicInstanceValue);
		}

	}

	@Override
	public SpecInstanceEntityCharacterValue  newCharacterValue(){
		return new BICharacterValue();
	}
	
	@Override
	public void addInstanceEntityCharacterValue(SpecInstanceEntityCharacterValue characteristicInstanceValue) {
		this.addBICharacteristicInstanceValue((BICharacterValue)characteristicInstanceValue);		
	}
}
