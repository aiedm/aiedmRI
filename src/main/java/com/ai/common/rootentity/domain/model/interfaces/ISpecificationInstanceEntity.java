package com.ai.common.rootentity.domain.model.interfaces;

import java.util.Set;

public interface ISpecificationInstanceEntity extends IInstanceEntity {
	Set<IInstanceEntityCharacteristic> getCharacteristics();
	void addCharacteristic(IInstanceEntityCharacteristic instanceEntityCharacteristic);
	IInstanceEntityCharacteristic getInstEntityCharByCode(Set<IInstanceEntityCharacteristic> instCharacteristics,String characteristicCode)  throws Exception;
	IInstanceEntityCharacteristic getInstEntityCharById(Set<IInstanceEntityCharacteristic> instCharacteristics,long characteristicId)  throws Exception;
	String getInstEntityCharValueByCharCode(Set<IInstanceEntityCharacteristic> instCharacteristics,String characteristicCode,int valuePosition)  throws Exception;
	String getInstEntityCharValueByCharId(Set<IInstanceEntityCharacteristic> instCharacteristics,long characteristicId,int valuePosition)  throws Exception;
	String getInstEntityCharValue(IInstanceEntityCharacteristic instCharacteristic,int valuePosition) throws Exception;
}
