package com.ai.crm.common.businessinteractionspec.domain.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.ai.common.rootentity.domain.model.CharacteristicSpec;
import com.ai.common.rootentity.domain.model.RootEntity;
@Entity
public class BISpecCharacter extends RootEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private BusinessInteractionSpec businessInteractionSpec;
	@OneToOne
	private CharacteristicSpec characteristic;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="biSpecCharacter")
	private Set<BISpecCharacterValue> characteristicValues=new HashSet<BISpecCharacterValue>();
	
	public BusinessInteractionSpec getBusinessInteractionSpec() {
		return this.businessInteractionSpec;
	}

	
	public void setBusinessInteractionSpec(BusinessInteractionSpec businessInteractionSpec) {
		this.businessInteractionSpec=businessInteractionSpec;
	}

	
	public CharacteristicSpec getCharacteristic() {
		return (CharacteristicSpec)this.characteristic;
	}

	
	public void setCharacteristic(CharacteristicSpec characteristic) {
		this.characteristic=characteristic;
	}

	
	public Set<BISpecCharacterValue> getCharacteristicValues() {
		return this.characteristicValues;
	}

	
	public void addCharacteristicValue(BISpecCharacterValue characteristicValue) {
		characteristicValues.add(characteristicValue);
		if (null==characteristicValue.getBiSpecCharacter()){
			characteristicValue.setBiSpecCharacter(this);
		}
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}
}
