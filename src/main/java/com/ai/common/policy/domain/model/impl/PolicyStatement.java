package com.ai.common.policy.domain.model.impl;

import java.util.LinkedHashSet;
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
	public String toBodyString() {
		StringBuffer sb=new StringBuffer();
		String firstParam="";
		String secondParam="";
		if(null!=this.getVariable()){
			firstParam=this.getVariable().toBodyString();
		}
		if(null!=this.getValue()){
			secondParam=this.getValue().toBodyString();
		}
		sb.append(this.getOperator().toBodyString(firstParam,secondParam));
		return sb.toString();
	}
	
	@Override
	public Set<IPolicyVariable> getVariables(){
		Set<IPolicyVariable> variables=new LinkedHashSet<IPolicyVariable>();
		variables.add(this.getVariable());
		Set<IPolicyVariable> valueVars=this.getValue().getVariables();
		if (null!=valueVars&&valueVars.size()>0){
			variables.addAll(valueVars);
		}
		return variables;
	}
	

}
