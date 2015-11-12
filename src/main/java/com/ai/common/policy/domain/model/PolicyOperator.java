package com.ai.common.policy.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.ai.common.rootentity.domain.model.InstanceEntity;
@Entity
public abstract class PolicyOperator extends InstanceEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;	
	private String name;
	private String code;	
	public PolicyOperator() {
	}
	
	public String toBodyString(String a,String b) {
		StringBuffer sb=new StringBuffer();
		sb.append(a).append(this.getCode()).append(b);
		return sb.toString();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
