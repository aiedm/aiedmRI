package com.ai.crm.customerorder.application.service.api.util;

import java.util.Set;

import com.ai.common.rootentity.domain.model.CharacteristicSpec;
import com.ai.common.rootentity.domain.model.CharacteristicSpecValue;
import com.ai.common.rootentity.domain.model.SpecInstanceEntityCharacter;
import com.ai.common.rootentity.domain.model.SpecInstanceEntityCharacterValue;
import com.ai.crm.customerorder.application.service.api.dto.CharacterInstanceDTO;
import com.ai.crm.customerorder.application.service.api.dto.CharacterValueInstanceDTO;

public class CharacteristicDTOTransHelper {

	public CharacteristicDTOTransHelper() {
	}

	public static void transCharacteristic(SpecInstanceEntityCharacter character,CharacterInstanceDTO characterInstanceDTO){
		if (characterInstanceDTO.getCharacterInstanceId()>0){
			character.setId(characterInstanceDTO.getCharacterInstanceId());
		}		
		CharacteristicSpec characterSpec=new CharacteristicSpec();
		characterSpec.setId(characterInstanceDTO.getCharacteristicSpecId());
		character.setCharacteristicSpec(characterSpec);
		character.setAction(characterInstanceDTO.getAction());
		Set<CharacterValueInstanceDTO> characterValues=characterInstanceDTO.getCharacteristicValues();
		if(characterValues.size()>0){
			for (CharacterValueInstanceDTO characterValueInstanceDTO : characterValues) {						
				SpecInstanceEntityCharacterValue characterValue=character.newCharacterValue();
				transCharacteristicValue(characterValue,characterValueInstanceDTO);
				character.addInstanceEntityCharacterValue(characterValue);
			}
		}
	}
	
	public static void transCharacteristicValue(SpecInstanceEntityCharacterValue characterValue,CharacterValueInstanceDTO characterValueInstanceDTO){
		if(characterValueInstanceDTO.getCharacterValueInstanceId()>0){
			characterValue.setId(characterValueInstanceDTO.getCharacterValueInstanceId());
		}
		
		CharacteristicSpecValue characterSpecValue=new CharacteristicSpecValue();
		characterSpecValue.setId(characterValueInstanceDTO.getCharacteristicSpecValueId());
		characterValue.setCharacteristicValue(characterSpecValue);
		characterValue.setInputedValue(characterValueInstanceDTO.getInputedValue());
		characterValue.setAction(characterValueInstanceDTO.getAction());
	}
	
}
