package com.ai.common.rootentity.domain.service.impl;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

import com.ai.common.bpmn.model.BaseEvent;
import com.ai.common.rootentity.domain.service.interfaces.IEventPublisher;
@Component
public class SpringEventPublisher implements IEventPublisher, ApplicationEventPublisherAware{
	public SpringEventPublisher(){
		
	}
	private ApplicationEventPublisher publisher;

	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.publisher=applicationEventPublisher;				
	}

	public void publishEvent(BaseEvent event) {
		publisher.publishEvent(event);		
	}
	
}
