package com.ai.common.rootentity.domain.model.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import  com.ai.common.policy.domain.model.interfaces.IPolicySet;

import com.ai.common.rootentity.domain.model.interfaces.ISpecificationEntity;
public class EventSubscriberRule {
	private BaseEvent event;
	private ISpecificationEntity subscriber;
	private Set<IPolicySet> onEventActionRules=new LinkedHashSet<>();
	public BaseEvent getEvent() {
		return event;
	}

	public void setEvent(BaseEvent event) {
		this.event = event;
	}

	public ISpecificationEntity getSubscriber() {
		return subscriber;
	}
	
	public void setSubscriber(ISpecificationEntity subscriber) {
		this.subscriber = subscriber;
	}

	public Set<IPolicySet> getOnEventActionRules() {
		return onEventActionRules;
	}

	public void addOnEventActionRule(IPolicySet actionRule) {
		if(null!=actionRule){
			this.onEventActionRules.add(actionRule);
		}		
	}

	public EventSubscriberRule() {
		// TODO Auto-generated constructor stub
	}

}
