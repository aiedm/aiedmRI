package com.ai.common.policy.domain.model.impl;

import com.ai.common.policy.domain.model.interfaces.IPolicyOperatorNot;

public class PolicyOperatorNot extends PolicyOperator implements IPolicyOperatorNot {

	public PolicyOperatorNot() {
	}

	@Override
	public String toBodyString(String a,String b) {
		StringBuffer sb=new StringBuffer();
		sb.append(this.getCode()).append(a);
		return sb.toString();
	}
}
