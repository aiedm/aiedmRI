package com.ai.common.rootentity.domain.model.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.context.ApplicationEvent;

import com.ai.common.policy.domain.model.interfaces.IPolicyCondition;

public class BaseEvent extends ApplicationEvent {
	private Set<EventSubscriberRule> eventSubscriberRules=new LinkedHashSet<EventSubscriberRule>();
	private Set<IPolicyCondition> conditions=new LinkedHashSet<IPolicyCondition>();
	private Set<EventListener> listeners=new LinkedHashSet<EventListener>();
	
	public BaseEvent(Object source) {
		super(source);
		System.out.println("EVENT triggered:"+this);
	}

	public Set<EventListener> getListeners(){
		return this.listeners;
	}
	
	public void addListener(EventListener listener){
		if (null!=listener){
			this.listeners.add(listener);
			if (null==listener.getEvent()){
				listener.setEvent(this);
			}
			
		}
	}
	
	public Set<EventSubscriberRule> getEventSubscriberRules() {
		return eventSubscriberRules;
	}
	public void addEventSubscriberRule(EventSubscriberRule eventSubscriberRule) {
		if (null!=eventSubscriberRule){
			this.eventSubscriberRules.add(eventSubscriberRule);
			if (null==eventSubscriberRule.getEvent()){
				eventSubscriberRule.setEvent(this);
			}
		}
	}
	public Set<IPolicyCondition> getConditions() {
		return conditions;
	}
	public void addCondition(IPolicyCondition condition) {
		if (null!=condition){
			this.conditions.add(condition);
		}
		
	}
	
}
