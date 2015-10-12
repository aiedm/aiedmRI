package com.ai.common.policy.domain.model.interfaces;

import com.ai.common.rootentity.domain.model.interfaces.IInstanceEntity;

public interface IPolicyFunctionVariableParam extends IInstanceEntity {
	IPolicyFunctionVariable getFunctionVariable();
	void setFunctionVariable(IPolicyFunctionVariable variable);
	IPolicyFunctionParameter getParameter();
	void setParameter(IPolicyFunctionParameter param);
	IPolicyVariable getVaraibleValueRef();
	void setVaraibleValueRef(IPolicyVariable ariableValue);
	Object getValue();
	void setValue(Object value);
}
