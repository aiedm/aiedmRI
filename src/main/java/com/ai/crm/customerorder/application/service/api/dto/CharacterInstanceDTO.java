package com.ai.crm.customerorder.application.service.api.dto;

import java.util.LinkedHashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
@JsonTypeInfo(
	    use = JsonTypeInfo.Id.NAME,
	    include = JsonTypeInfo.As.PROPERTY,
	    property = "type")
@JsonSubTypes({
			@Type(value = CharacterInstanceDTO.class, name = "CharacterInstanceDTO")
})
public class CharacterInstanceDTO {
	private long characteristicSpecId;
	private long characterInstanceId;
	private Set<CharacterValueInstanceDTO> CharacteristicValues=new LinkedHashSet<CharacterValueInstanceDTO>();
	private int action;
	
	public int getAction() {
		return action;
	}


	public void setAction(int action) {
		this.action = action;
	}
	public long getCharacteristicSpecId() {
		return characteristicSpecId;
	}
	public void setCharacteristicSpecId(long characteristicSpecId) {
		this.characteristicSpecId = characteristicSpecId;
	}
	public Set<CharacterValueInstanceDTO> getCharacteristicValues() {
		return CharacteristicValues;
	}
	public void addCharacteristicValue(CharacterValueInstanceDTO characteristicValue) {
		if(null!=characteristicValue){
			CharacteristicValues.add(characteristicValue);
		}
	}
	public CharacterInstanceDTO() {
	}


	public long getCharacterInstanceId() {
		return characterInstanceId;
	}


	public void setCharacterInstanceId(long characterInstanceId) {
		this.characterInstanceId = characterInstanceId;
	}

}
