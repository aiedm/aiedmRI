package com.ai.common.rootentity.domain.model.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.ai.common.rootentity.domain.model.interfaces.ICharacteristicSpec;
import com.ai.common.rootentity.domain.model.interfaces.ISpecificationEntity;
import com.ai.common.rootentity.domain.model.interfaces.ISubscribedEvent;
@Component
public class SpecificationEntity extends RootEntity implements ISpecificationEntity {
	private Set<ICharacteristicSpec> characteristSpecs=new HashSet<ICharacteristicSpec>();
	private String name;
	private String code;
	private Set<ISubscribedEvent> subscribedEvents=new HashSet<ISubscribedEvent>();
	

	@Override
	public Set<ICharacteristicSpec> getCharacteristSpecs() {
		return this.characteristSpecs;
	}

	@Override
	public void addCharacteristSpec(ICharacteristicSpec characteristicSpec) {
		if (null!=characteristicSpec){
			this.characteristSpecs.add(characteristicSpec);
		}
		
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name=name;
	}

	@Override
	public String getCode() {
		return this.code;
	}

	@Override
	public void setCode(String code) {
		this.code=code;
	}

	@Override
	public Set<ISubscribedEvent> getSubscribedEvents() {
		return this.subscribedEvents;
	}

	@Override
	public void addSubscribedEvent(ISubscribedEvent event) {
		if (event!=null){
			subscribedEvents.add(event);
			if (null==event.getOwner()){
				event.setOwner(this);
			}
		}		
	}

}
