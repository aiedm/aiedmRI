package com.ai.crm.customerorder.application.service.api.dto;

import java.util.LinkedHashSet;
import java.util.Set;

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
