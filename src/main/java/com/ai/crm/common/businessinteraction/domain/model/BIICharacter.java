package com.ai.crm.common.businessinteraction.domain.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.ai.common.rootentity.domain.model.SpecInstanceEntityCharacter;
@Entity
public class BIICharacter extends SpecInstanceEntityCharacter {
	@ManyToOne
	private BusinessInteractionItem businessInteractionItem;
	@OneToMany(mappedBy="biiCharacter")
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

}
