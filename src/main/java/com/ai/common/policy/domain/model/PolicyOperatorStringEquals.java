package com.ai.common.policy.domain.model;

public class PolicyOperatorStringEquals extends PolicyOperator{

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
