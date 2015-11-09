package com.ai.crm.customerorder.application.service.api.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

@JsonTypeInfo(
	    use = JsonTypeInfo.Id.NAME,
	    include = JsonTypeInfo.As.PROPERTY,
	    property = "type")
@JsonSubTypes({
			@Type(value = CharacterValueInstanceDTO.class, name = "CharacterValueInstanceDTO")
})
public class CharacterValueInstanceDTO {
	private long CharacteristicSpecValueId;
	private long characterValueInstanceId;
	private String inputedValue;	
	private int action;
	
	public int getAction() {
		return action;
	}


	public void setAction(int action) {
		this.action = action;
	}	
	public CharacterValueInstanceDTO() {
	}
	public long getCharacteristicSpecValueId() {
		return CharacteristicSpecValueId;
	}
	public void setCharacteristicSpecValueId(long characteristicSpecValueId) {
		CharacteristicSpecValueId = characteristicSpecValueId;
	}
	public String getInputedValue() {
		return inputedValue;
	}
	public void setInputedValue(String inputedValue) {
		this.inputedValue = inputedValue;
	}


	public long getCharacterValueInstanceId() {
		return characterValueInstanceId;
	}


	public void setCharacterValueInstanceId(long characterValueInstanceId) {
		this.characterValueInstanceId = characterValueInstanceId;
	}

}
