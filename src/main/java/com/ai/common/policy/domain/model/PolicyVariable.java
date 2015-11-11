package com.ai.common.policy.domain.model;

import com.ai.common.rootentity.domain.model.CharacteristicSpec;
import com.ai.common.rootentity.domain.model.InstanceEntity;

public class PolicyVariable extends InstanceEntity{
	private long id;
	private String name;
	private String code;
	private String type;
	private CharacteristicSpec characteristicSpec;
	private String initialInputValue;
	private PolicyValue value;
	public PolicyVariable() {
	}

	
	public long getId() {
		return this.id;
	}

	
	public void setId(long id) {
		this.id=id;
	}

	
	public String getName() {
		return this.name;
	}

	
	public void setName(String name) {
		this.name=name;
	}

	
	public String getCode() {
		return this.code;
	}

	
	public void setCode(String code) {
		this.code=code;
	}

	
	public Object getVariableType() {
		return this.type;
	}

	
	public void setVariableType(String type) {
		this.type=type;
	}

	
	public CharacteristicSpec getEnumCharacteristic() {
		return this.characteristicSpec;
	}

	
	public void setEnumCharacteristic(CharacteristicSpec characteristicSpec) {
		this.characteristicSpec=characteristicSpec;
	}

	
	public String toBodyString(){
		return this.getCode();
	}

	
	public String getInitialInputValue() {
		return this.initialInputValue;
	}

	
	public void setInitialInputValue(String inputValue) {
		this.initialInputValue=inputValue;
	}

	
	public PolicyValue getInitialValue() {
		// TODO Auto-generated method stub
		return this.value;
	}

	
	public void setInitialValue(PolicyValue value) {
		this.value=value;
	}

}