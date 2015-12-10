package com.ai.common.policy.domain.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ai.common.rootentity.domain.model.InstanceEntity;
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@Table(name="PL_ACTION")
@DiscriminatorColumn(name="TYPE",discriminatorType=DiscriminatorType.STRING)
public abstract class PolicyAction extends InstanceEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String code;
	@Column(insertable = false, updatable = false,name="TYPE")
	private String type;
	
	@ManyToOne
	private PolicyAction parentAction;
	
	@OneToOne
	private PolicySet policyset;
	
	protected PolicyAction(PolicySet policyset){
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


	public PolicySet getPolicyset() {
		return policyset;
	}


	public void setPolicyset(PolicySet policyset) {
		this.policyset = policyset;
	}

}
