package com.ai.common.policy.domain.model.impl;

import com.ai.common.policy.domain.model.interfaces.IPolicyOperatorMethodInvoke;

public class PolicyOperatorMethodInvoke extends PolicyActionOperator implements IPolicyOperatorMethodInvoke {

	public PolicyOperatorMethodInvoke() {
	}
	@Override
	public String toBodyString(String a,String b) {
		StringBuffer sb=new StringBuffer();
		if (!a.isEmpty()){
			sb.append(a).append(" = ");
		}
		sb.append(b);
		return sb.toString();
	}
}
