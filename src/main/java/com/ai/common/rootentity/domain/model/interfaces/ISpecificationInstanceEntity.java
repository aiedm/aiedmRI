package com.ai.common.rootentity.domain.model.interfaces;

import java.util.Set;

public interface ISpecificationInstanceEntity extends IInstanceEntity {
	Set<IInstanceEntityCharacter> getCharacteristics();
	void addCharacteristic(IInstanceEntityCharacter instanceEntityCharacteristic);
	IInstanceEntityCharacter getInstEntityCharByCode(String characteristicCode)  throws Exception;
	IInstanceEntityCharacter getInstEntityCharById(long characteristicId)  throws Exception;
	String getInstEntityCharValueByCharCode(String characteristicCode,int valuePosition)  throws Exception;
	String getInstEntityCharValueByCharId(long characteristicId,int valuePosition)  throws Exception;
	String getInstEntityCharValue(IInstanceEntityCharacter instCharacteristic,int valuePosition) throws Exception;
}
