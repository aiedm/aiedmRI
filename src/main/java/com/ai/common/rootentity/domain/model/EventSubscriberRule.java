package com.ai.common.rootentity.domain.model;

import java.util.LinkedHashSet;
import java.util.Set;

import com.ai.common.policy.domain.model.PolicySet;

public class EventSubscriberRule {
	private BaseEvent event;
	private SpecificationEntity subscriber;
	private Set<PolicySet> onEventActionRules=new LinkedHashSet<>();
	public BaseEvent getEvent() {
		return event;
	}

	public void setEvent(BaseEvent event) {
		this.event = event;
	}

	public SpecificationEntity getSubscriber() {
		return subscriber;
	}
	
	public void setSubscriber(SpecificationEntity subscriber) {
		this.subscriber = subscriber;
	}

	public Set<PolicySet> getOnEventActionRules() {
		return onEventActionRules;
	}

	public void addOnEventActionRule(PolicySet actionRule) {
		if(null!=actionRule){
			this.onEventActionRules.add(actionRule);
		}		
	}

	public EventSubscriberRule() {
		// TODO Auto-generated constructor stub
	}

}
