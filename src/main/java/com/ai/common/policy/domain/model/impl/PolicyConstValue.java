package com.ai.common.policy.domain.model.impl;

import com.ai.common.policy.domain.model.interfaces.IPolicyConstValue;

public class PolicyConstValue extends PolicyValue implements IPolicyConstValue {
	public PolicyConstValue() {
	}

	@Override
	public String toPolicyString() {
		StringBuffer sb=new StringBuffer();
		String value=this.getValue();
		if (null!=value){
			if (this.getType().equalsIgnoreCase("String")){
				sb.append("'").append(value).append("'");
			}else{
				sb.append(value);
			}
		}	
		return sb.toString();
	}

}
