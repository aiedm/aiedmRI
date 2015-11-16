package com.ai.common.policy.domain.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

import com.ai.common.rootentity.domain.model.InstanceEntity;
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class PolicyAction extends InstanceEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String code;
	
	@ManyToOne
	private PolicyAction parentAction;
	
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

	
	public abstract String toBodyString();
	
	
	public abstract Set<PolicyVariable> getVariables();


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public PolicyAction getParentAction() {
		return parentAction;
	}


	public void setParentAction(PolicyAction parentAction) {
		this.parentAction = parentAction;
	}

}
