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

@Entity
public class SubscribedEvent extends InstanceEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;	
	@ManyToOne	
	private SpecificationEntity instanceEntity;
	@ManyToOne
	private BaseEvent event;
	@OneToMany(fetch=FetchType.LAZY,mappedBy="subscribedEvent")
	private  Set<SubscribedEventPolicies> policies = new LinkedHashSet<SubscribedEventPolicies>();
	public SubscribedEvent() {
	}

	
	public SpecificationEntity getOwner() {
		return this.instanceEntity;
	}

	
	public void setOwner(SpecificationEntity instanceEntity) {
		this.instanceEntity=(SpecificationEntity)instanceEntity;
	}

	
	public BaseEvent getEvent() {
		return this.event;
	}

	
	public void setEvent(BaseEvent event) {
		this.event=event;
	}

	
	public Set<SubscribedEventPolicies> getPolicies() {
		return this.policies;
	}

	
	public void addPolicy(SubscribedEventPolicies policySet) {
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
