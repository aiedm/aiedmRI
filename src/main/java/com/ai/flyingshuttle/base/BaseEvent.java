package com.ai.flyingshuttle.base;

import org.springframework.context.ApplicationEvent;

public class BaseEvent extends ApplicationEvent {

	public BaseEvent(Object source) {
		super(source);
		System.out.println("EVENT triggered:"+this+",triggered by:"+this);
	}

}
