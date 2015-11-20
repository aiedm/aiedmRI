package com.ai.crm.common.businessinteractionspec.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.ai.common.rootentity.domain.model.CharacteristicSpecValue;
import com.ai.common.rootentity.domain.model.RootEntity;

@Entity
public class BIISpecCharacterValue extends RootEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne
	private BIISpecCharacter biiSpecCharacter;
	@OneToOne
	private CharacteristicSpecValue characteristicSpecValue;

	
	public BIISpecCharacter getBiiSpecCharacter() {
		return this.biiSpecCharacter;
	}

	
	public void setBiiSpecCharacter(BIISpecCharacter biSpecCharacter) {
		this.biiSpecCharacter=biSpecCharacter;
		
	}

	
	public CharacteristicSpecValue getCharacteristicValue() {
		return this.characteristicSpecValue;
	}

	
	public void setCharacteristicValue(CharacteristicSpecValue characteristicValue) {
		this.characteristicSpecValue=characteristicValue;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


}
