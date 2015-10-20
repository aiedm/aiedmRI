package com.ai.common.policy.domain.model.impl;

import com.ai.common.policy.domain.model.interfaces.IPolicyMethodInvokeValue;

public class PolicyMethodInvokeValue extends PolicyValue implements IPolicyMethodInvokeValue {

	public PolicyMethodInvokeValue() {
	}

	@Override
	public String toBodyString() {
		StringBuffer sb=new StringBuffer();
		sb.append(this.getCode()).append("(").append(this.getValue()).append(")");
		return sb.toString();
	}

}
