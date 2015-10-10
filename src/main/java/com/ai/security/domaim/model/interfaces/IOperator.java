package com.ai.security.domaim.model.interfaces;

import com.ai.common.rootentity.domain.model.interfaces.IRootEntity;

public interface IOperator extends IRootEntity {
	String getOperatorId();
	void setOperatorId(String operatorId);
	String getPassword();
	void setPassword(String password);
}
