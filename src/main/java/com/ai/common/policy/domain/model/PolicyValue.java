package com.ai.common.policy.domain.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.ai.common.rootentity.domain.model.InstanceEntity;
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@Table(name="PL_VALUE")
public abstract class PolicyValue extends InstanceEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;	
	private String name;
	private String code;
	private String type;
	private String value;
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public PolicyValue() {
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
	
	
	public String getValue() {
		return this.value;
	}

	
	public void setValue(String value) {
		this.value=value;
	}	

	
	public abstract String toBodyString();
	
	
	public abstract Set<PolicyVariable> getVariables();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	} 
}
