package com.ai.common.policy.domain.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ai.common.rootentity.domain.model.InstanceEntity;
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@Table(name="PL_RULE_PARAMETER")
public class PolicyRuleParameter extends InstanceEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private PolicyVariable variable;
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="POLICY_RULE_ID")
	private PolicyRule policyRule;

	public PolicyRuleParameter() {
	}
	
	public PolicyVariable getVariable() {
		return this.variable;
	}

	
	public void setVariable(PolicyVariable variable) {
		this.variable=variable;
	}

	
	public PolicyRule getPolicyRule() {
		return this.policyRule;
	}
	
	public void setPolicyRule(PolicyRule policyRule) {
		this.policyRule=policyRule;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
