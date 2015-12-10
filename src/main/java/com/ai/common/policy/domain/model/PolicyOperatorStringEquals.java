package com.ai.common.policy.domain.model;

import javax.persistence.Entity;

@Entity
public class PolicyOperatorStringEquals extends PolicyConditionOperator{

	public PolicyOperatorStringEquals() {
	}
	
	
	public String toBodyString(String a,String b) {
		StringBuffer sb=new StringBuffer();
		sb.append(a)
			.append(".")
			.append(this.getCode())
			.append("(")
			.append(b)
			.append(")");
		return sb.toString();
	}
}
