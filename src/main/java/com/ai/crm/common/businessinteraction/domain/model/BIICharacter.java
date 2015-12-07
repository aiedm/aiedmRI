package com.ai.crm.common.businessinteraction.domain.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ai.common.rootentity.domain.model.SpecInstanceEntityCharacter;
import com.ai.common.rootentity.domain.model.SpecInstanceEntityCharacterValue;
@Entity
@Table(name="BII_CHARACTER")
public class BIICharacter extends SpecInstanceEntityCharacter {
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
	@JoinColumn(name="BIZ_INTERACTION_ITEM_ID")
	private BusinessInteractionItem businessInteractionItem;
	@OneToMany(mappedBy="biiCharacter",fetch=FetchType.EAGER)
	private Set<BIICharacterValue> biiCharacterValues=new LinkedHashSet<BIICharacterValue>();
	public BIICharacter() {
	}
	public BusinessInteractionItem getBusinessInteractionItem() {
		return businessInteractionItem;
	}
	public void setBusinessInteractionItem(BusinessInteractionItem businessInteractionItem) {
		this.businessInteractionItem = businessInteractionItem;
	}
	public Set<BIICharacterValue> getBIICharacteristicInstanceValues() {
		return this.biiCharacterValues;
	}

	
	public void addBIICharacteristicInstanceValue(BIICharacterValue characteristicInstanceValue) {
		this.biiCharacterValues.add(characteristicInstanceValue);
		if (null==characteristicInstanceValue.getBiiCharacter()){
			characteristicInstanceValue.setBiiCharacter(this);
			super.addCharacteristicInstanceValue(characteristicInstanceValue);
		}

	}
	
	@Override
	public SpecInstanceEntityCharacterValue  newCharacterValue(){
		return new BIICharacterValue();
	}
	
	@Override
	public void addInstanceEntityCharacterValue(SpecInstanceEntityCharacterValue characteristicInstanceValue) {
		this.addBIICharacteristicInstanceValue((BIICharacterValue)characteristicInstanceValue);		
	}

}
