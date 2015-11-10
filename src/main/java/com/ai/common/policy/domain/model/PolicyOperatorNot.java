package com.ai.common.policy.domain.model;

public class PolicyOperatorNot extends PolicyOperator{

	public PolicyOperatorNot() {
	}

	@Override
	public String toBodyString(String a,String b) {
		StringBuffer sb=new StringBuffer();
		sb.append(this.getCode()).append(a);
		return sb.toString();
	}
}
