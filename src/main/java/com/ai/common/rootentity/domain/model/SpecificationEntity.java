package com.ai.common.rootentity.domain.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

@Entity
public abstract  class SpecificationEntity extends RootEntity{
	@Id
	private long id;	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="specificationEntity")
	private Set<SpecEntityCharacter> characteristSpecs=new LinkedHashSet<SpecEntityCharacter>();
	@Column
	private String name;
	@Column
	private String code;

	

	
	public Set<SpecEntityCharacter> getCharacteristSpecs() {
		return this.characteristSpecs;
	}

	
	public void addCharacteristSpec(SpecEntityCharacter characteristicSpec) {
		if (null!=characteristicSpec){
			this.characteristSpecs.add(characteristicSpec);
		}
		
	}

	
	public String getName() {
		return this.name;
	}

	
	public void setName(String name) {
		this.name=name;
	}

	
	public String getCode() {
		return this.code;
	}

	
	public void setCode(String code) {
		this.code=code;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}

}
