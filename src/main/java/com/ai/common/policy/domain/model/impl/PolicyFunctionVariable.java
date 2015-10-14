package com.ai.common.policy.domain.model.impl;

import java.util.HashSet;
import java.util.Set;

import com.ai.common.policy.domain.model.interfaces.IPolicyFunction;
import com.ai.common.policy.domain.model.interfaces.IPolicyFunctionVariable;
import com.ai.common.policy.domain.model.interfaces.IPolicyFunctionVariableParamRel;

public class PolicyFunctionVariable extends PolicyVariable implements IPolicyFunctionVariable {
	private IPolicyFunction function;
	Set<IPolicyFunctionVariableParamRel> params=new HashSet<IPolicyFunctionVariableParamRel>();
	public PolicyFunctionVariable() {
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
		Set<IPolicyFunctionVariableParamRel> params=this.getParams();
		for (IPolicyFunctionVariableParamRel paramRel : params) {
			if(null!=paramRel.getVaraibleValueRef()){
				sb.append(paramRel.getVaraibleValueRef());
			}else{
				sb.append(paramRel.getValue());
			}
			sb.append(",");
		}
		if(sb.lastIndexOf(",")==sb.length()-1){
			sb.delete(sb.length()-1, sb.length()-1);
		}
		sb.append(")");
		return sb.toString();
	}


	@Override
	public Set<IPolicyFunctionVariableParamRel> getParams() {
		return this.params;
	}


	@Override
	public void addParam(IPolicyFunctionVariableParamRel param) {
		if(null!=param){
			params.add(param);
			if (null==param.getFunctionVariable()){
				param.setFunctionVariable(this);
			}
		}
		
	}

}
