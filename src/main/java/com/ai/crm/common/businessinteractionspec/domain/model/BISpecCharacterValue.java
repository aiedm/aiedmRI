package com.ai.crm.common.businessinteractionspec.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ai.common.rootentity.domain.model.CharacteristicSpecValue;
import com.ai.common.rootentity.domain.model.RootEntity;

@Entity
@Table(name="BISPEC_CHARACTER_VALUE")
public class BISpecCharacterValue extends RootEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne
	private BISpecCharacter biSpecCharacter;
	@OneToOne
	private CharacteristicSpecValue characteristicSpecValue;

	
	public BISpecCharacter getBiSpecCharacter() {
		return this.biSpecCharacter;
	}

	
	public void setBiSpecCharacter(BISpecCharacter biSpecCharacter) {
		this.biSpecCharacter=biSpecCharacter;
		
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
