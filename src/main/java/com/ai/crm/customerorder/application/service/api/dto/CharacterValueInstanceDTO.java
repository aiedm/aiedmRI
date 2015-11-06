package com.ai.crm.customerorder.application.service.api.dto;

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
