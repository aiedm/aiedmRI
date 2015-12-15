package com.ai.common.policy.domain.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ai.common.rootentity.domain.model.CharacteristicSpec;
import com.ai.common.rootentity.domain.model.InstanceEntity;
@Entity
@Table(name="PL_VARIABLE")
public class PolicyVariable extends InstanceEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;	
	private String name;
	private String code;
	private String type;
	@OneToOne
	private CharacteristicSpec characteristicSpec;
	private String initialInputValue;
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private PolicyValue value;
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private PolicySet policyset;
	
	public PolicyVariable(PolicySet policyset) {
		this.setPolicyset(policyset);
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

	
	public Object getVariableType() {
		return this.type;
	}

	
	public void setVariableType(String type) {
		this.type=type;
	}

	
	public CharacteristicSpec getEnumCharacteristic() {
		return this.characteristicSpec;
	}

	
	public void setEnumCharacteristic(CharacteristicSpec characteristicSpec) {
		this.characteristicSpec=characteristicSpec;
	}

	
	public String toBodyString(){
		return this.getCode();
	}

	
	public String getInitialInputValue() {
		return this.initialInputValue;
	}

	
	public void setInitialInputValue(String inputValue) {
		this.initialInputValue=inputValue;
	}

	
	public PolicyValue getInitialValue() {
		// TODO Auto-generated method stub
		return this.value;
	}

	
	public void setInitialValue(PolicyValue value) {
		this.value=value;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public PolicySet getPolicyset() {
		return policyset;
	}


	public void setPolicyset(PolicySet policyset) {
		this.policyset = policyset;
	}

}
