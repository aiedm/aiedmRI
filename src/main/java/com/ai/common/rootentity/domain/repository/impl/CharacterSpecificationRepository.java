package com.ai.common.rootentity.domain.repository.impl;

import org.springframework.stereotype.Component;

import com.ai.common.rootentity.domain.model.CharacteristicSpec;
import com.ai.common.rootentity.domain.model.CharacteristicSpecValue;
import com.ai.common.rootentity.domain.repository.interfaces.ICharacterSpecificationRepository;
@Component
public class CharacterSpecificationRepository implements ICharacterSpecificationRepository {

	public CharacterSpecificationRepository() {
		
	}

	
	public CharacteristicSpec getCharacteristicSpecById(long characteristicSpecId) throws Exception {
		CharacteristicSpec charspec=new CharacteristicSpec();
		charspec.setCode("Color");
		CharacteristicSpecValue charSpecValue=new CharacteristicSpecValue();
		charSpecValue.setCharacteristic(charspec);
		charSpecValue.setCode("Gold");
		charSpecValue.setValue("Gold");
		charspec.addValue(charSpecValue);
		return charspec;
	}

	
	public CharacteristicSpecValue getCharacteristicSpecValueById(long characteristicSpecValueId) throws Exception {
		CharacteristicSpecValue charSpecValue=new CharacteristicSpecValue();
		charSpecValue.setCode("Gold");
		charSpecValue.setValue("Gold");
		return charSpecValue;
	}
	
	

}
