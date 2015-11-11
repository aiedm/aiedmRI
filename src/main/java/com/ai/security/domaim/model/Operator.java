package com.ai.security.domaim.model;

import com.ai.common.rootentity.domain.model.RootEntity;

public class Operator extends RootEntity {
	private String operatorId;
	private String password;

	
	public String getOperatorId() {
		return this.operatorId;
	}

	
	public void setOperatorId(String operatorId) {
		this.operatorId=operatorId;
	}

	
	public String getPassword() {
		return this.password;
	}

	
	public void setPassword(String password) {
		this.password=password;
	}

}
