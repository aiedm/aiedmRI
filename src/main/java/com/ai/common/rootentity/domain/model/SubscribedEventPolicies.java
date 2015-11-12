package com.ai.common.rootentity.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.ai.common.policy.domain.model.PolicySet;
@Entity
public class SubscribedEventPolicies extends InstanceEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;	
	@OneToOne
	private SubscribedEvent subscribedEvent;
	@OneToOne
	private PolicySet policySet;
	public SubscribedEventPolicies() {
	}
	public SubscribedEvent getSubscribedEvent() {
		return subscribedEvent;
	}
	public void setSubscribedEvent(SubscribedEvent subscribedEvent) {
		this.subscribedEvent = subscribedEvent;
	}
	public PolicySet getPolicySet() {
		return policySet;
	}
	public void setPolicySet(PolicySet policySet) {
		this.policySet = policySet;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

}
