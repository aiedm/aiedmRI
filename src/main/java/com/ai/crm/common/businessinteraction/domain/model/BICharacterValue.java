package com.ai.crm.common.businessinteraction.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ai.common.rootentity.domain.model.SpecInstanceEntityCharacterValue;
@Entity
@Table(name="BI_CHARACTER_VALUE")
public class BICharacterValue extends SpecInstanceEntityCharacterValue {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}	
	@ManyToOne
	private BICharacter biCharacter;
	public BICharacterValue() {
	}

	public BICharacter getBiCharacter() {
		return biCharacter;
	}

	public void setBiCharacter(BICharacter biCharacter) {
		this.biCharacter = biCharacter;
	}

}
