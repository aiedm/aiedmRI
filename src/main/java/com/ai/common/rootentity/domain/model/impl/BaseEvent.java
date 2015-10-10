package com.ai.common.rootentity.domain.model.impl;

import org.springframework.context.ApplicationEvent;

public class BaseEvent extends ApplicationEvent {

	public BaseEvent(Object source) {
		super(source);
		System.out.println("EVENT triggered:"+this);
	}

}
