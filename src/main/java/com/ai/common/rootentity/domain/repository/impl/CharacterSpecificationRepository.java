package com.ai.common.rootentity.domain.repository.impl;

import org.springframework.stereotype.Component;

import com.ai.common.rootentity.domain.model.impl.CharacteristicSpec;
import com.ai.common.rootentity.domain.model.impl.CharacteristicSpecValue;
import com.ai.common.rootentity.domain.model.interfaces.ICharacteristicSpec;
import com.ai.common.rootentity.domain.model.interfaces.ICharacteristicSpecValue;
import com.ai.common.rootentity.domain.repository.interfaces.ICharacterSpecificationRepository;
@Component
public class CharacterSpecificationRepository implements ICharacterSpecificationRepository {

	public CharacterSpecificationRepository() {
		
	}

	@Override
	public ICharacteristicSpec getCharacteristicSpecById(long characteristicSpecId) throws Exception {
		ICharacteristicSpec charspec=new CharacteristicSpec();
		charspec.setCode("Color");
		ICharacteristicSpecValue charSpecValue=new CharacteristicSpecValue();
		charSpecValue.setCharacteristic(charspec);
		charSpecValue.setCode("Gold");
		charSpecValue.setValue("Gold");
		charspec.addValue(charSpecValue);
		return charspec;
	}

	@Override
	public ICharacteristicSpecValue getCharacteristicSpecValueById(long characteristicSpecValueId) throws Exception {
		ICharacteristicSpecValue charSpecValue=new CharacteristicSpecValue();
		charSpecValue.setCode("Gold");
		charSpecValue.setValue("Gold");
		return charSpecValue;
	}
	
	

}
