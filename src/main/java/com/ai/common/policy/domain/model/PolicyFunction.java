package com.ai.common.policy.domain.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ai.common.rootentity.domain.model.InstanceEntity;
@Entity
@Table(name="PL_FUNCTION")
public class PolicyFunction extends InstanceEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;	
	private String name;
	private String code;
	private String returnType;
	private String className;
	private String methodName;
	@OneToMany(mappedBy="function",fetch=FetchType.LAZY)
	Set<PolicyFunctionParameter> parameters=new HashSet<PolicyFunctionParameter>();
	public PolicyFunction() {
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

	
	public Set<PolicyFunctionParameter> getParameters() {
		return this.parameters;
	}

	
	public void addParameter(PolicyFunctionParameter param) {
		if(null!=param){
			this.parameters.add(param);
		}
	}

	
	public String returnType() {
		return this.returnType;
	}

	
	public void setReturnType(String type) {
		this.returnType=type;
	}

	
	public String getClassName() {
		return this.className;
	}

	
	public void setClassName(String className) {
		this.className=className;
	}

	
	public String getMethodName() {
		return this.methodName;
	}

	
	public void setMethodName(String methodName) {
		this.methodName=methodName;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}

}
