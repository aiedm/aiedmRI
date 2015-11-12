package com.ai.common.rootentity.domain.model;

import java.util.HashSet;
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
import javax.persistence.OneToOne;
@Entity
public class SpecEntityCharacteristic extends RootEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name="SPECIFICATION_ENTITY_ID")
	private SpecificationEntity specificationEntity;
	@OneToOne
	@JoinColumn(name="CHARACTER_ID")
	private CharacteristicSpec characteristic;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="specificationEntityCharacteristic")
	private Set<SpecEntityCharacterValue> characteristicValues=new HashSet<SpecEntityCharacterValue>();
	
	public SpecificationEntity getSpecificationEntity() {
		return this.specificationEntity;
	}

	
	public void setSpecificationEntity(SpecificationEntity specificationEntity) {
		this.specificationEntity=(SpecificationEntity)specificationEntity;
	}

	
	public CharacteristicSpec getCharacteristic() {
		return (CharacteristicSpec)this.characteristic;
	}

	
	public void setCharacteristic(CharacteristicSpec characteristic) {
		this.characteristic=characteristic;
	}

	
	public Set<SpecEntityCharacterValue> getCharacteristicValues() {
		return this.characteristicValues;
	}

	
	public void addCharacteristicValue(SpecEntityCharacterValue characteristicValue) {
		characteristicValues.add(characteristicValue);
		if (null==characteristicValue.getOwnerCharacteristic()){
			characteristicValue.setOwnerCharacteristic(this);
		}
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}
}
