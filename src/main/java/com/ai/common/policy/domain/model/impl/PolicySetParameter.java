package com.ai.common.policy.domain.model.impl;

import com.ai.common.policy.domain.model.interfaces.IPolicySet;
import com.ai.common.policy.domain.model.interfaces.IPolicySetParameter;
import com.ai.common.policy.domain.model.interfaces.IPolicyVariable;
import com.ai.common.rootentity.domain.model.impl.InstanceEntity;

public class PolicySetParameter extends InstanceEntity implements IPolicySetParameter {
	private long id;
	private IPolicyVariable variable;
	private IPolicySet policySet;

	public PolicySetParameter() {
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
	public IPolicyVariable getVariable() {
		return this.variable;
	}

	@Override
	public void setVariable(IPolicyVariable variable) {
		this.variable=variable;
	}

	@Override
	public IPolicySet getPolicySet() {
		return this.policySet;
	}

	@Override
	public void setPolicySet(IPolicySet policySet) {
		this.policySet=policySet;
	}

}
