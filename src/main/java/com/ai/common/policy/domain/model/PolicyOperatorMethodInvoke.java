package com.ai.common.policy.domain.model;


public class PolicyOperatorMethodInvoke extends PolicyActionOperator{

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
