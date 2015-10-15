package com.ai.common.policy.domain.model.interfaces;

import com.ai.common.rootentity.domain.model.interfaces.IInstanceEntity;

public interface IPolicyFunctionValueParamRel extends IInstanceEntity {
	IPolicyFunctionValue getFunctionValue();
	void setFunctionValue(IPolicyFunctionValue value);
	IPolicyFunctionParameter getParameter();
	void setParameter(IPolicyFunctionParameter param);
	IPolicyVariable getVaraibleValueRef();
	void setVaraibleValueRef(IPolicyVariable variableValue);
	String getValue();
	void setValue(String value);
}
