package com.ai.common.policy.domain.model.impl;

import com.ai.common.policy.domain.model.interfaces.IPolicyOperator;
import com.ai.common.rootentity.domain.model.impl.SpecificationEntity;

public class PolicyOperator extends SpecificationEntity implements IPolicyOperator {

	public PolicyOperator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setId(long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public String toPolicyString() {
		return this.getCode();
	}

}
