package com.ai.crm.customerorder.application.service.api.util;

import java.util.Set;

import com.ai.common.rootentity.domain.model.CharacteristicSpec;
import com.ai.common.rootentity.domain.model.CharacteristicSpecValue;
import com.ai.common.rootentity.domain.model.SpecInstanceEntityCharacter;
import com.ai.common.rootentity.domain.model.SpecInstanceEntityCharacterValue;
import com.ai.crm.common.businessinteraction.domain.model.BICharacterValue;
import com.ai.crm.customerorder.application.service.api.dto.CharacterInstanceDTO;
import com.ai.crm.customerorder.application.service.api.dto.CharacterValueInstanceDTO;

public class CharacteristicDTOTransHelper {

	public CharacteristicDTOTransHelper() {
	}

	public static void transCharacteristic(SpecInstanceEntityCharacter character,CharacterInstanceDTO characterInstanceDTO){
		character.setId(characterInstanceDTO.getCharacterInstanceId());
		CharacteristicSpec characterSpec=new CharacteristicSpec();
		characterSpec.setId(characterInstanceDTO.getCharacteristicSpecId());
		character.setCharacteristicSpec(characterSpec);
		character.setAction(characterInstanceDTO.getAction());
		Set<CharacterValueInstanceDTO> characterValues=characterInstanceDTO.getCharacteristicValues();
		if(characterValues.size()>0){
			for (CharacterValueInstanceDTO characterValueInstanceDTO : characterValues) {						
				BICharacterValue characterValue=new BICharacterValue();
				transCharacteristicValue(characterValue,characterValueInstanceDTO);
				character.addCharacteristicInstanceValue(characterValue);
			}
		}
	}
	
	public static void transCharacteristicValue(SpecInstanceEntityCharacterValue characterValue,CharacterValueInstanceDTO characterValueInstanceDTO){
		characterValue.setCharacterValueInstanceId(characterValueInstanceDTO.getCharacterValueInstanceId());
		CharacteristicSpecValue characterSpecValue=new CharacteristicSpecValue();
		characterSpecValue.setId(characterValueInstanceDTO.getCharacteristicSpecValueId());
		characterValue.setCharacteristicValue(characterSpecValue);
		characterValue.setInputedValue(characterValueInstanceDTO.getInputedValue());
		characterValue.setAction(characterValueInstanceDTO.getAction());
	}
	
}
