package com.ai.common.policy.domain.model.impl;

import com.ai.common.policy.domain.model.interfaces.IPolicyOperator;
import com.ai.common.policy.domain.model.interfaces.IPolicyStatement;
import com.ai.common.policy.domain.model.interfaces.IPolicyValue;
import com.ai.common.policy.domain.model.interfaces.IPolicyVariable;
import com.ai.common.rootentity.domain.model.impl.InstanceEntity;

public class PolicyStatement extends InstanceEntity implements IPolicyStatement {
	private long id;
	private String name;
	private String code;
	public PolicyStatement() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public long getId() {
		return this.id;
	}

	@Override
	public void setId(long id) {
		this.id=id;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name=name;
	}

	@Override
	public String getCode() {
		return this.code;
	}

	@Override
	public void setCode(String code) {
		this.code=code;
	}	

	@Override
	public IPolicyVariable getVariable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setVariable(IPolicyVariable varible) {
		// TODO Auto-generated method stub

	}

	@Override
	public IPolicyOperator getOperator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setOperator(IPolicyOperator Operator) {
		// TODO Auto-generated method stub

	}

	@Override
	public IPolicyValue getValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setValue(IPolicyValue value) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean hasCharacteristic() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toPolicyString() {
		StringBuffer sb=new StringBuffer();
		sb.append(this.getOperator().toPolicyString(this.getVariable().toPolicyString(),this.getValue().toPolicyString()));
		return sb.toString();
	}

}
