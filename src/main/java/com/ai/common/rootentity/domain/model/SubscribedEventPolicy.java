package com.ai.common.rootentity.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.ai.common.policy.domain.model.PolicySet;
@Entity
public class SubscribedEventPolicy extends InstanceEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;	
	@ManyToOne
	private EventSubscriber subscribedEvent;
	@OneToOne
	private PolicySet policySet;
	public SubscribedEventPolicy() {
	}
	public EventSubscriber getSubscribedEvent() {
		return subscribedEvent;
	}
	public void setSubscribedEvent(EventSubscriber subscribedEvent) {
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
