package com.ai.common.rootentity.domain.model.interfaces;

import java.util.Set;

public interface ISpecificationEntity extends IRootEntity {
	Set<ICharacteristicSpec> getCharacteristSpecs();
	void addCharacteristSpec(ICharacteristicSpec characteristicSpec);
	String getName();
	void setName(String name);
	String getCode();
	void setCode(String code);
	Set<ISubscribedEvent> getSubscribedEvents();
	void addSubscribedEvent(ISubscribedEvent event);		
}
