package com.ai.common.rootentity.domain.model.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.context.ApplicationEvent;

import com.ai.common.policy.domain.model.interfaces.IPolicyCondition;
import com.ai.common.rootentity.domain.model.interfaces.IBaseEvent;
import com.ai.common.rootentity.domain.model.interfaces.IEventSubscriberRule;

public class BaseEvent extends ApplicationEvent implements IBaseEvent{
	private Set<IEventSubscriberRule> eventSubscriberRules=new LinkedHashSet<IEventSubscriberRule>();
	private Set<IPolicyCondition> conditions=new LinkedHashSet<IPolicyCondition>();

	public BaseEvent(Object source) {
		super(source);
		System.out.println("EVENT triggered:"+this);
	}

	@Override
	public Set<IEventSubscriberRule> getEventSubscriberRules() {
		return eventSubscriberRules;
	}
	@Override
	public void addEventSubscriberRule(IEventSubscriberRule eventSubscriberRule) {
		if (null!=eventSubscriberRule){
			this.eventSubscriberRules.add(eventSubscriberRule);
			if (null==eventSubscriberRule.getEvent()){
				eventSubscriberRule.setEvent(this);
			}
		}
	}
	@Override
	public Set<IPolicyCondition> getConditions() {
		return conditions;
	}
	@Override
	public void addCondition(IPolicyCondition condition) {
		if (null!=condition){
			this.conditions.add(condition);
		}
		
	}
	
}
