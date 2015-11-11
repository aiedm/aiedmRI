package com.ai.common.policy.domain.model;

import java.util.LinkedHashSet;
import java.util.Set;

import com.ai.common.rootentity.domain.model.InstanceEntity;

public abstract class PolicyStatement extends InstanceEntity{
	private long id;
	private String name;
	private String code;
	private PolicyVariable varible;
	private PolicyValue value;

	public PolicyStatement() {
	}
	
	
	public long getId() {
		return this.id;
	}

	
	public void setId(long id) {
		this.id=id;
	}

	
	public String getName() {
		return this.name;
	}

	
	public void setName(String name) {
		this.name=name;
	}

	
	public String getCode() {
		return this.code;
	}

	
	public void setCode(String code) {
		this.code=code;
	}	

	
	public PolicyVariable getVariable() {
		return this.varible;
	}

	
	public void setVariable(PolicyVariable varible) {
		this.varible=varible;
	}

	
	public abstract PolicyOperator getOperator();

	
	public abstract void setOperator(PolicyOperator operator);

	
	public PolicyValue getValue() {
		return this.value;
	}

	
	public void setValue(PolicyValue value) {
		this.value=value;
	}

	
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
	
	
	public Set<PolicyVariable> getVariables(){
		Set<PolicyVariable> variables=new LinkedHashSet<PolicyVariable>();
		variables.add(this.getVariable());
		Set<PolicyVariable> valueVars=this.getValue().getVariables();
		if (null!=valueVars&&valueVars.size()>0){
			variables.addAll(valueVars);
		}
		return variables;
	}
	

}