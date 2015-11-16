package com.ai.common.rootentity.domain.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@MappedSuperclass
public abstract class SpecInstanceEntityCharacter extends RootEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne
	private SpecInstanceEntity specInstanceEntity;
	@OneToOne
	private CharacteristicSpec characteristicSpec;
	
	@OneToMany (fetch=FetchType.LAZY,mappedBy="specInstanceEntityCharacteristic")
	private Set<SpecInstanceEntityCharacterValue> characteristicInstanceValues=new LinkedHashSet<SpecInstanceEntityCharacterValue>();
	
	private int action;
	
	public int getAction() {
		return action;
	}


	public void setAction(int action) {
		this.action = action;
	}
	
	public SpecInstanceEntity getOwnerInstance() {
		return this.specInstanceEntity;
	}

	
	public void setOwnerInstance(SpecInstanceEntity instanceEntity) {
		this.specInstanceEntity=instanceEntity;
	}

	
	public CharacteristicSpec getCharacteristicSpec() {
		return this.characteristicSpec;
	}

	
	public void setCharacteristicSpec(CharacteristicSpec characteristic) {
		this.characteristicSpec=characteristic;
	}

	
	public Set<SpecInstanceEntityCharacterValue> getCharacteristicInstanceValues() {
		return this.characteristicInstanceValues;
	}

	
	public void addCharacteristicInstanceValue(SpecInstanceEntityCharacterValue characteristicInstanceValue) {
		this.characteristicInstanceValues.add(characteristicInstanceValue);
		if (null==characteristicInstanceValue.getInstanceEntityCharacteristic()){
			characteristicInstanceValue.setInstanceEntityCharacteristic(this);
		}

	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}

}
