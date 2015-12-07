package com.ai.crm.common.businessinteraction.domain.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ai.common.rootentity.domain.model.SpecInstanceEntityCharacterValue;
@Entity
@Table(name="BII_CHARACTER_VALUE")
public class BIICharacterValue extends SpecInstanceEntityCharacterValue {
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
	@JoinColumn(name="BIZ_INTERACTION_ITEM_CHAR_ID")
	private BIICharacter biiCharacter;
	public BIICharacterValue() {
	}

	public BIICharacter getBiiCharacter() {
		return biiCharacter;
	}

	public void setBiiCharacter(BIICharacter biCharacter) {
		this.biiCharacter = biCharacter;
	}

}
