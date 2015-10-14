package com.ai.common.policy.domain.model.impl;

import com.ai.common.policy.domain.model.interfaces.IPolicyOperatorStringEquals;

public class PolicyOperatorStringEquals extends PolicyOperator implements IPolicyOperatorStringEquals {

	public PolicyOperatorStringEquals() {
	}
	
	@Override
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
