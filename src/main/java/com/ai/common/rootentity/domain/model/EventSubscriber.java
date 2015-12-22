package com.ai.common.rootentity.domain.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.ai.common.bpmn.model.BaseEvent;

@Entity
@Table(name="RT_EVENT_SUBSCRIBER")
public class EventSubscriber extends InstanceEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;	
	@Transient	
	private SpecificationEntity subscriber;
	@ManyToOne
	private BaseEvent event;
	@OneToMany(fetch=FetchType.LAZY,mappedBy="subscribedEvent")
	private  Set<SubscribedEventPolicy> policies = new LinkedHashSet<SubscribedEventPolicy>();
	public EventSubscriber() {
	}

	
	public SpecificationEntity getOwner() {
		return this.subscriber;
	}

	
	public void setOwner(SpecificationEntity instanceEntity) {
		this.subscriber=(SpecificationEntity)instanceEntity;
	}

	
	public BaseEvent getEvent() {
		return this.event;
	}

	
	public void setEvent(BaseEvent event) {
		this.event=event;
	}

	
	public Set<SubscribedEventPolicy> getPolicies() {
		return this.policies;
	}

	
	public void addPolicy(SubscribedEventPolicy policySet) {
		if(null!=policySet){
			policies.add(policySet);
		}
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}

}
