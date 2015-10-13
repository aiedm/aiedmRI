package com.ai.common.policy.domain.model.impl;

import java.util.Set;

import com.ai.common.policy.domain.model.interfaces.IPolicyFunction;
import com.ai.common.policy.domain.model.interfaces.IPolicyFunctionParameter;
import com.ai.common.rootentity.domain.model.impl.InstanceEntity;
import com.ai.common.rootentity.domain.model.interfaces.ICharacteristicSpec;
import com.ai.common.rootentity.domain.model.interfaces.ISubscribedEvent;

public class PolicyFunctionParameter extends InstanceEntity implements IPolicyFunctionParameter {

	public PolicyFunctionParameter() {
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
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCode(String code) {
		// TODO Auto-generated method stub

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
	public IPolicyFunction getFunction() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setFunction(IPolicyFunction function) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object getParameterType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setarameterType(Object param) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean hasCharacteristic() {
		// TODO Auto-generated method stub
		return false;
	}

}
