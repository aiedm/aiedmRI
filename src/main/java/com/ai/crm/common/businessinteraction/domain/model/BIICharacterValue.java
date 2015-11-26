package com.ai.crm.common.businessinteraction.domain.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ai.common.rootentity.domain.model.CharacteristicSpecValue;
import com.ai.common.rootentity.domain.model.SpecInstanceEntityCharacter;
import com.ai.common.rootentity.domain.model.SpecInstanceEntityCharacterValue;
@Entity
@Table(name="BII_CHARACTER_VALUE")
public class BIICharacterValue extends SpecInstanceEntityCharacterValue {
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="BIZ_INTERACTION_ITEM_CHAR_ID")
	private BIICharacter biiCharacter;
	public BIICharacterValue() {
	}

	public BIICharacterValue(SpecInstanceEntityCharacter instanceEntityCharacteristic, CharacteristicSpecValue characteristicValue) {
		super(instanceEntityCharacteristic, characteristicValue);
	}

	public BIICharacter getBiiCharacter() {
		return biiCharacter;
	}

	public void setBiiCharacter(BIICharacter biCharacter) {
		this.biiCharacter = biCharacter;
	}

}
