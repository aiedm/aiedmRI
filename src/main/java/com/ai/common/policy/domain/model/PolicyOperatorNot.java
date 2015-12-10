package com.ai.common.policy.domain.model;

import javax.persistence.Entity;

@Entity
public class PolicyOperatorNot extends PolicyConditionOperator{

	public PolicyOperatorNot() {
	}

	@Override
	public String toBodyString(String a,String b) {
		StringBuffer sb=new StringBuffer();
		sb.append(this.getCode()).append(a);
		return sb.toString();
	}
}
