package com.ai.common.rootentity.domain.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract  class SpecificationEntity extends RootEntity{
	@Id
	private long id;	
	@Column
	private String name;
	@Column
	private String code;

	
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


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}

}
