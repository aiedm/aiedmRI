package com.ai.common.policy.domain.model.impl;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import com.ai.common.policy.domain.model.interfaces.IPolicyFunction;
import com.ai.common.policy.domain.model.interfaces.IPolicyFunctionValue;
import com.ai.common.policy.domain.model.interfaces.IPolicyFunctionValueParamRel;
import com.ai.common.policy.domain.model.interfaces.IPolicyVariable;

public class PolicyFunctionValue extends PolicyValue implements IPolicyFunctionValue {
	private IPolicyFunction function;
	Set<IPolicyFunctionValueParamRel> params=new LinkedHashSet<IPolicyFunctionValueParamRel>();
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
		sb.append(this.getFunction().getClassName())
		.append(".")
		.append(this.getFunction().getMethodName())
		.append("(");
		Set<IPolicyFunctionValueParamRel> params=this.getParams();
		for (IPolicyFunctionValueParamRel paramRel : params) {
			sb.append(paramRel.toBodyString());
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
	
	@Override
	public Set<IPolicyVariable> getVariables() {
		Set<IPolicyVariable> variables=new HashSet<IPolicyVariable>();
		Set<IPolicyFunctionValueParamRel> params=this.getParams();
		for (IPolicyFunctionValueParamRel paramRel : params) {
			Set<IPolicyVariable> paramVariables=paramRel.getValue().getVariables();
			if (null!=paramVariables&&paramVariables.size()>0){
				variables.addAll(paramVariables);
			}			
		}
		return variables;
	}

}
