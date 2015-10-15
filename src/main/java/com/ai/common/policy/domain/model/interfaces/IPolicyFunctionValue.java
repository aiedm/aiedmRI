package com.ai.common.policy.domain.model.interfaces;
import java.util.Set;
public interface IPolicyFunctionValue extends IPolicyValue {
	IPolicyFunction getFunction();
	void setFunction(IPolicyFunction function);
	Set<IPolicyFunctionValueParamRel> getParams();
	void addParam(IPolicyFunctionValueParamRel param);
	
}
