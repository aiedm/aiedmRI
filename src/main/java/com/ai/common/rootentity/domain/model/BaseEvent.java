package com.ai.common.rootentity.domain.model;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.context.ApplicationEvent;

import com.ai.common.policy.domain.model.PolicyCondition;

public abstract class BaseEvent extends ApplicationEvent {
	private Set<EventSubscriberRule> eventSubscriberRules=new LinkedHashSet<EventSubscriberRule>();
	private Set<PolicyCondition> conditions=new LinkedHashSet<PolicyCondition>();
	private Set<EventListener> listeners=new LinkedHashSet<EventListener>();
	private String code;
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

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
	public Set<PolicyCondition> getConditions() {
		return conditions;
	}
	public void addCondition(PolicyCondition condition) {
		if (null!=condition){
			this.conditions.add(condition);
		}
		
	}
	
}
