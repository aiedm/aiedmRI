package com.ai.common.rootentity.domain.model.interfaces;

import java.util.Set;

public interface ISpecificationInstanceEntity extends IInstanceEntity {
	Set<IInstanceEntityCharacteristic> getCharacteristics();
	void addCharacteristic(IInstanceEntityCharacteristic instanceEntityCharacteristic);
	IInstanceEntityCharacteristic getInstEntityCharByCode(String characteristicCode)  throws Exception;
	IInstanceEntityCharacteristic getInstEntityCharById(long characteristicId)  throws Exception;
	String getInstEntityCharValueByCharCode(String characteristicCode,int valuePosition)  throws Exception;
	String getInstEntityCharValueByCharId(long characteristicId,int valuePosition)  throws Exception;
	String getInstEntityCharValue(IInstanceEntityCharacteristic instCharacteristic,int valuePosition) throws Exception;
}
