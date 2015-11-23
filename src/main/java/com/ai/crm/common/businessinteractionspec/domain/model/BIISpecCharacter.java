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
import javax.persistence.Table;

import com.ai.common.rootentity.domain.model.CharacteristicSpec;
import com.ai.common.rootentity.domain.model.RootEntity;
@Entity
@Table(name="BIISPEC_CHARACTER")
public class BIISpecCharacter extends RootEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private BusinessInteractionItemSpec businessInteractionItemSpec;
	@OneToOne
	private CharacteristicSpec characteristic;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="biiSpecCharacter")
	private Set<BIISpecCharacterValue> characteristicValues=new HashSet<BIISpecCharacterValue>();
	
	public BusinessInteractionItemSpec getBusinessInteractionItemSpec() {
		return this.businessInteractionItemSpec;
	}

	
	public void setBusinessInteractionItemSpec(BusinessInteractionItemSpec businessInteractionSpec) {
		this.businessInteractionItemSpec=businessInteractionSpec;
	}

	
	public CharacteristicSpec getCharacteristic() {
		return (CharacteristicSpec)this.characteristic;
	}

	
	public void setCharacteristic(CharacteristicSpec characteristic) {
		this.characteristic=characteristic;
	}

	
	public Set<BIISpecCharacterValue> getCharacteristicValues() {
		return this.characteristicValues;
	}

	
	public void addCharacteristicValue(BIISpecCharacterValue characteristicValue) {
		characteristicValues.add(characteristicValue);
		if (null==characteristicValue.getBiiSpecCharacter()){
			characteristicValue.setBiiSpecCharacter(this);
		}
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}
}
