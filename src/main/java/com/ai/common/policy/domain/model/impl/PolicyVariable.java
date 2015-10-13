package com.ai.common.policy.domain.model.impl;

import com.ai.common.policy.domain.model.interfaces.IPolicyValue;
import com.ai.common.policy.domain.model.interfaces.IPolicyVariable;
import com.ai.common.rootentity.domain.model.impl.InstanceEntity;
import com.ai.common.rootentity.domain.model.interfaces.ICharacteristicSpec;

public class PolicyVariable extends InstanceEntity implements IPolicyVariable {
	private long id;
	private String name;
	private String code;
	public PolicyVariable() {
		// TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setVariableType(String type) {
		// TODO Auto-generated method stub

	}

	@Override
	public ICharacteristicSpec getEnumCharacteristic() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setEnumCharacteristic(ICharacteristicSpec characteristicSpec) {
		// TODO Auto-generated method stub

	}

	@Override
	public IPolicyValue getInitialValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setIniatialValue(IPolicyValue value) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean hasCharacteristic() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toPolicyString(){
		return this.getCode();
	}

}
