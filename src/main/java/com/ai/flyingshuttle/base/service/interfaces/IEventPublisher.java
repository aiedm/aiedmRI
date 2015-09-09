package com.ai.flyingshuttle.base.service.interfaces;

import com.ai.flyingshuttle.base.BaseEvent;

public interface IEventPublisher {
	void publishEvent(BaseEvent event);
}
