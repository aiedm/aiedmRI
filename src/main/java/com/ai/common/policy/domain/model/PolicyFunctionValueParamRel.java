package com.ai.common.policy.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ai.common.rootentity.domain.model.InstanceEntity;
@Entity
@Table(name="PL_FUNCTION_VALUE_PARAM_REL")
public class PolicyFunctionValueParamRel extends InstanceEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;	
	@ManyToOne
	private PolicyFunctionValue functionValue;
	@OneToOne
	private PolicyFunctionParameter param;
	@OneToOne
	private PolicyValue value;
	public PolicyFunctionValueParamRel() {
	}

	
	public PolicyFunctionValue getFunctionValue() {
		return this.functionValue;
	}

	
	public void setFunctionValue(PolicyFunctionValue functionValue) {
		this.functionValue=functionValue;
	}

	
	public PolicyFunctionParameter getParameter() {
		return this.param;
	}

	
	public void setParameter(PolicyFunctionParameter param) {
		this.param=param;
	}

	
	public PolicyValue getValue() {
		return this.value;
	}

	
	public void setValue(PolicyValue value) {
		this.value=value;
	}

	
	public String toBodyString() {
		PolicyValue value=this.getValue();		
		return value.toBodyString();
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}

}
