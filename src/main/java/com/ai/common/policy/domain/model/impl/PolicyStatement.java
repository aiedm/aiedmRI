package com.ai.common.policy.domain.model.impl;

import java.util.Set;

import com.ai.common.policy.domain.model.interfaces.IPolicyOperator;
import com.ai.common.policy.domain.model.interfaces.IPolicyStatement;
import com.ai.common.policy.domain.model.interfaces.IPolicyValue;
import com.ai.common.policy.domain.model.interfaces.IPolicyVariable;
import com.ai.common.rootentity.domain.model.impl.InstanceEntity;

public abstract class PolicyStatement extends InstanceEntity implements IPolicyStatement {
	private long id;
	private String name;
	private String code;
	private IPolicyVariable varible;
	private IPolicyValue value;
	public PolicyStatement() {
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
		return this.varible;
	}

	@Override
	public void setVariable(IPolicyVariable varible) {
		this.varible=varible;
	}

	@Override
	public abstract IPolicyOperator getOperator();

	@Override
	public abstract void setOperator(IPolicyOperator operator);

	@Override
	public IPolicyValue getValue() {
		return this.value;
	}

	@Override
	public void setValue(IPolicyValue value) {
		this.value=value;
	}

	@Override
	public boolean hasCharacteristic() {
		return false;
	}

	@Override
	public String toBodyString() {
		StringBuffer sb=new StringBuffer();
		sb.append(this.getOperator().toBodyString(this.getVariable().toBodyString(),this.getValue().toBodyString()));
		return sb.toString();
	}

}
