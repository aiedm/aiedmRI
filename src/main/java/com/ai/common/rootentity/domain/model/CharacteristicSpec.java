package com.ai.common.rootentity.domain.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CharacteristicSpec extends RootEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String name;
	@Column
	private String code;


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
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="characteristic")
	private Set<CharacteristicSpecValue> values=new java.util.LinkedHashSet<CharacteristicSpecValue>();

	
	public Set<CharacteristicSpecValue> getValues() {
		return this.values;
	}

	
	public void addValue(CharacteristicSpecValue value) {
		if (null!=value){
			values.add(value);
		}
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
