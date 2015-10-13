package com.ai.common.policy.domain.model.interfaces;
import java.util.Set;
public interface IPolicyFunctionVariable extends IPolicyVariable {
	IPolicyFunction getFunction();
	void setFunction(IPolicyFunction function);
	Set<IPolicyFunctionVariableParamRel> getParams();
	void addParam(IPolicyFunctionVariableParamRel param);
	
}
