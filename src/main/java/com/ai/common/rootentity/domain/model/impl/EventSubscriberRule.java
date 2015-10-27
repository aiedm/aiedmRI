package com.ai.common.rootentity.domain.model.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import  com.ai.common.policy.domain.model.interfaces.IPolicySet;
import com.ai.common.rootentity.domain.model.interfaces.IBaseEvent;
import com.ai.common.rootentity.domain.model.interfaces.IEventSubscriberRule;
import com.ai.common.rootentity.domain.model.interfaces.ISpecificationEntity;
public class EventSubscriberRule implements IEventSubscriberRule{
	private IBaseEvent event;
	private ISpecificationEntity subscriber;
	private Set<IPolicySet> onEventActionRules=new LinkedHashSet<>();
	public IBaseEvent getEvent() {
		return event;
	}

	@Override
	public void setEvent(IBaseEvent event) {
		this.event = event;
	}

	@Override
	public ISpecificationEntity getSubscriber() {
		return subscriber;
	}
	
	@Override
	public void setSubscriber(ISpecificationEntity subscriber) {
		this.subscriber = subscriber;
	}

	@Override
	public Set<IPolicySet> getOnEventActionRules() {
		return onEventActionRules;
	}

	@Override
	public void addOnEventActionRule(IPolicySet actionRule) {
		if(null!=actionRule){
			this.onEventActionRules.add(actionRule);
		}		
	}

	public EventSubscriberRule() {
		// TODO Auto-generated constructor stub
	}

}
