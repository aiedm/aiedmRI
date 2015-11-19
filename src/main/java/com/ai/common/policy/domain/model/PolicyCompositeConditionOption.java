package com.ai.common.policy.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ai.common.rootentity.domain.model.InstanceEntity;
@Entity
@Table(name="PL_COMPOSITE_CONDITION_OPTION")
public class PolicyCompositeConditionOption extends InstanceEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@JoinColumn(name="PARENT_CONDITION_ID")
	@OneToOne
	private PolicyCompositeCondition parent;
	@OneToOne
	@JoinColumn(name="CHILD_CONDITION_ID")
	private PolicyCondition child;
	
	public PolicyCompositeConditionOption() {
	}

	
	public PolicyCondition getChildCondition() {
		return this.child;
	}

	
	public void setChildCondition(PolicyCondition child) {
		this.child=child;
	}

	
	public PolicyCompositeCondition getParentCondition() {
		return this.parent;
	}

	
	public void setParentCondition(PolicyCompositeCondition parent) {
		this.parent=parent;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}

}
