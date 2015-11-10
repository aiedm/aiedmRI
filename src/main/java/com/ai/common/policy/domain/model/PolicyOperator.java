package com.ai.common.policy.domain.model;

import com.ai.common.rootentity.domain.model.SpecificationEntity;

public abstract class PolicyOperator extends SpecificationEntity{
	private long id;

	public PolicyOperator() {
	}

	
	public long getId() {
		return this.id;
	}

	
	public void setId(long id) {
		this.id=id;
	}

	
	public String toBodyString(String a,String b) {
		StringBuffer sb=new StringBuffer();
		sb.append(a).append(this.getCode()).append(b);
		return sb.toString();
	}

}
