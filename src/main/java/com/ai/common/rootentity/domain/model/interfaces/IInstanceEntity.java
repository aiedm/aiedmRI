package com.ai.common.rootentity.domain.model.interfaces;

import java.util.Set;

public interface IInstanceEntity extends IRootEntity {
	boolean hasCharacteristic();
	Set<IInstanceEntityCharacteristic> getCharacteristics();
	void addCharacteristic(IInstanceEntityCharacteristic instanceEntityCharacteristic);
}
