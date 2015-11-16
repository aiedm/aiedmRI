package com.ai.common.rootentity.domain.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract  class SpecificationEntity extends RootEntity{
	@Id
	private long id;	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="specificationEntity")
	private Set<SpecEntityCharacteristic> characteristSpecs=new LinkedHashSet<SpecEntityCharacteristic>();
	@Column
	private String name;
	@Column
	private String code;
	@OneToMany(fetch=FetchType.LAZY,mappedBy="subscriber")
	private Set<EventSubscriber> subscribedEvents=new LinkedHashSet<EventSubscriber>();
	

	
	public Set<SpecEntityCharacteristic> getCharacteristSpecs() {
		return this.characteristSpecs;
	}

	
	public void addCharacteristSpec(SpecEntityCharacteristic characteristicSpec) {
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

	
	public Set<EventSubscriber> getSubscribedEvents() {
		return this.subscribedEvents;
	}
	
	
	public void addSubscribedEvent(EventSubscriber event) {
		if (event!=null){
			subscribedEvents.add(event);
			if (null==event.getOwner()){
				event.setOwner(this);
			}
		}		
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}

}
