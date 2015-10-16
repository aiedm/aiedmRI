package com.ai.common.policy.domain.model.impl;

import java.util.HashSet;
import java.util.Set;

import com.ai.common.policy.domain.model.interfaces.IPolicyFunction;
import com.ai.common.policy.domain.model.interfaces.IPolicyFunctionValue;
import com.ai.common.policy.domain.model.interfaces.IPolicyFunctionValueParamRel;

public class PolicyFunctionValue extends PolicyValue implements IPolicyFunctionValue {
	private IPolicyFunction function;
	Set<IPolicyFunctionValueParamRel> params=new HashSet<IPolicyFunctionValueParamRel>();
	public PolicyFunctionValue() {
	}


	@Override
	public IPolicyFunction getFunction() {
		return this.function;
	}

	@Override
	public void setFunction(IPolicyFunction function) {
		this.function=function;		
	}


	@Override
	public String toBodyString() {
		StringBuffer sb=new StringBuffer();
		sb.append(this.getFunction().getCode()).append("(");
		Set<IPolicyFunctionValueParamRel> params=this.getParams();
		for (IPolicyFunctionValueParamRel paramRel : params) {
			if(null!=paramRel.getVaraibleValueRef()){
				sb.append(paramRel.getVaraibleValueRef().getCode());
			}else{
				sb.append(paramRel.getValue());
			}
			sb.append(",");
		}
		int lastIdx=sb.lastIndexOf(",");
		if(lastIdx>0){
			sb.delete(lastIdx, sb.length());
		}
		sb.append(")");
		return sb.toString();
	}


	@Override
	public Set<IPolicyFunctionValueParamRel> getParams() {
		return this.params;
	}


	@Override
	public void addParam(IPolicyFunctionValueParamRel param) {
		if(null!=param){
			params.add(param);
			if (null==param.getFunctionValue()){
				param.setFunctionValue(this);
			}
		}
		
	}
	
	@Override
	public String getValue() {
		return this.toBodyString();
	}

	@Override
	public void setValue(String value) {
		// do nothing
	}

}
