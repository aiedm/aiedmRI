package com.ai.common.rootentity.domain.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

@Entity
@Inheritance (strategy = InheritanceType.TABLE_PER_CLASS)
@Component
public class SpecificationEntity extends RootEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="specificationEntity")
	private Set<SpecificationEntityCharacteristic> characteristSpecs=new LinkedHashSet<SpecificationEntityCharacteristic>();
	@Column
	private String name;
	@Column
	private String code;
	@OneToMany(fetch=FetchType.LAZY,mappedBy="SpecificationEntity")
	private Set<SubscribedEvent> subscribedEvents=new LinkedHashSet<SubscribedEvent>();
	

	
	public Set<SpecificationEntityCharacteristic> getCharacteristSpecs() {
		return this.characteristSpecs;
	}

	
	public void addCharacteristSpec(SpecificationEntityCharacteristic characteristicSpec) {
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

	
	public Set<SubscribedEvent> getSubscribedEvents() {
		return this.subscribedEvents;
	}
	
	
	public long getId() {
		return this.id;
	}

	
	public void setId(long id) {
		this.id=id;
	}		

	
	public void addSubscribedEvent(SubscribedEvent event) {
		if (event!=null){
			subscribedEvents.add(event);
			if (null==event.getOwner()){
				event.setOwner(this);
			}
		}		
	}

}
