package com.ai.security.domaim.model.impl;

import com.ai.crm.common.rootentity.impl.RootEntity;
import com.ai.security.domaim.model.interfaces.IOperator;

public class Operator extends RootEntity implements IOperator {
	private String operatorId;
	private String password;

	@Override
	public String getOperatorId() {
		return this.operatorId;
	}

	@Override
	public void setOperatorId(String operatorId) {
		this.operatorId=operatorId;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public void setPassword(String password) {
		this.password=password;
	}

}
