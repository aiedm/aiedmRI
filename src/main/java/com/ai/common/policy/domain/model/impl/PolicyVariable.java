package com.ai.common.policy.domain.model.impl;

import com.ai.common.policy.domain.model.interfaces.IPolicyVariable;
import com.ai.common.rootentity.domain.model.impl.InstanceEntity;
import com.ai.common.rootentity.domain.model.interfaces.ICharacteristicSpec;

public class PolicyVariable extends InstanceEntity implements IPolicyVariable {
	private long id;
	private String name;
	private String code;
	private String type;
	private ICharacteristicSpec characteristicSpec;
	public PolicyVariable() {
	}

	@Override
	public long getId() {
		return this.id;
	}

	@Override
	public void setId(long id) {
		this.id=id;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name=name;
	}

	@Override
	public String getCode() {
		return this.code;
	}

	@Override
	public void setCode(String code) {
		this.code=code;
	}

	@Override
	public Object getVariableType() {
		return this.type;
	}

	@Override
	public void setVariableType(String type) {
		this.type=type;
	}

	@Override
	public ICharacteristicSpec getEnumCharacteristic() {
		return this.characteristicSpec;
	}

	@Override
	public void setEnumCharacteristic(ICharacteristicSpec characteristicSpec) {
		this.characteristicSpec=characteristicSpec;
	}

	@Override
	public boolean hasCharacteristic() {
		return false;
	}

	@Override
	public String toBodyString(){
		return this.getCode();
	}

}
