package com.ai.common.policy.domain.model.impl;

import java.util.Set;

import com.ai.common.policy.domain.model.interfaces.IPolicyFunction;
import com.ai.common.policy.domain.model.interfaces.IPolicyFunctionParameter;
import com.ai.common.rootentity.domain.model.impl.InstanceEntity;
import com.ai.common.rootentity.domain.model.interfaces.ICharacteristicSpec;
import com.ai.common.rootentity.domain.model.interfaces.ISubscribedEvent;

public class PolicyFunction extends InstanceEntity implements IPolicyFunction {
	private long id;
	private String name;
	private String code;
	public PolicyFunction() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Set<ICharacteristicSpec> getCharacteristSpecs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addCharacteristSpec(ICharacteristicSpec characteristicSpec) {
		// TODO Auto-generated method stub

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
	public Set<ISubscribedEvent> getSubscribedEvents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addSubscribedEvent(ISubscribedEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public Set<IPolicyFunctionParameter> getParameters() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addParameter(IPolicyFunctionParameter param) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean hasCharacteristic() {
		// TODO Auto-generated method stub
		return false;
	}

}
