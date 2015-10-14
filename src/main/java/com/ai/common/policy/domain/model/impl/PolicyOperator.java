package com.ai.common.policy.domain.model.impl;

import com.ai.common.policy.domain.model.interfaces.IPolicyOperator;
import com.ai.common.rootentity.domain.model.impl.SpecificationEntity;

public abstract class PolicyOperator extends SpecificationEntity implements IPolicyOperator {
	private long id;

	public PolicyOperator() {
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
	public String toBodyString(String a,String b) {
		StringBuffer sb=new StringBuffer();
		sb.append(a).append(this.getCode()).append(b);
		return sb.toString();
	}

}
