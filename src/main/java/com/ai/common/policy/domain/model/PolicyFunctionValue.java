package com.ai.common.policy.domain.model;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class PolicyFunctionValue extends PolicyValue {
	private PolicyFunction function;
	Set<PolicyFunctionValueParamRel> params=new LinkedHashSet<PolicyFunctionValueParamRel>();
	public PolicyFunctionValue() {
	}


	
	public PolicyFunction getFunction() {
		return this.function;
	}

	
	public void setFunction(PolicyFunction function) {
		this.function=function;		
	}


	
	public String toBodyString() {
		StringBuffer sb=new StringBuffer();
		sb.append(this.getFunction().getClassName())
		.append(".")
		.append(this.getFunction().getMethodName())
		.append("(");
		Set<PolicyFunctionValueParamRel> params=this.getParams();
		for (PolicyFunctionValueParamRel paramRel : params) {
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


	
	public Set<PolicyFunctionValueParamRel> getParams() {
		return this.params;
	}


	
	public void addParam(PolicyFunctionValueParamRel param) {
		if(null!=param){
			params.add(param);
			if (null==param.getFunctionValue()){
				param.setFunctionValue(this);
			}
		}
		
	}
	
	
	public String getValue() {
		return this.toBodyString();
	}

	
	public void setValue(String value) {
		// do nothing
	}
	
	
	public Set<PolicyVariable> getVariables() {
		Set<PolicyVariable> variables=new HashSet<PolicyVariable>();
		Set<PolicyFunctionValueParamRel> params=this.getParams();
		for (PolicyFunctionValueParamRel paramRel : params) {
			Set<PolicyVariable> paramVariables=paramRel.getValue().getVariables();
			if (null!=paramVariables&&paramVariables.size()>0){
				variables.addAll(paramVariables);
			}			
		}
		return variables;
	}

}