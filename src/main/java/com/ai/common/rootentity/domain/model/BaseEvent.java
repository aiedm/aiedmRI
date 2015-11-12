package com.ai.common.rootentity.domain.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.context.ApplicationEvent;

import com.ai.common.policy.domain.model.PolicyCondition;
@Entity
public abstract class BaseEvent extends ApplicationEvent {
	@Transient
	private Set<EventSubscriberRule> eventSubscriberRules=new LinkedHashSet<EventSubscriberRule>();
	@Transient
	private Set<PolicyCondition> conditions=new LinkedHashSet<PolicyCondition>();
	@Transient
	private Set<EventListener> listeners=new LinkedHashSet<EventListener>();
	@Id
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
