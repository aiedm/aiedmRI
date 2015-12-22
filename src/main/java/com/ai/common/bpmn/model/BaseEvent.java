package com.ai.common.bpmn.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.context.ApplicationEvent;

import com.ai.common.policy.domain.model.PolicyCondition;
import com.ai.common.rootentity.domain.model.EventSubscriber;
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@Table(name="RT_EVENT")
public abstract class BaseEvent extends ApplicationEvent {
	@Transient
	private Set<EventSubscriber> eventSubscribers=new LinkedHashSet<EventSubscriber>();
	@Transient
	private Set<PolicyCondition> conditions=new LinkedHashSet<PolicyCondition>();
	@Transient
	private Set<EventListener> listeners=new LinkedHashSet<EventListener>();
	@Id
	private String code;
	
	private String packageName;
	
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
	
	public Set<EventSubscriber> getEventSubscriberRules() {
		return eventSubscribers;
	}
	public void addEventSubscriberRule(EventSubscriber eventSubscriberRule) {
		if (null!=eventSubscriberRule){
			this.eventSubscribers.add(eventSubscriberRule);
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

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	
}
