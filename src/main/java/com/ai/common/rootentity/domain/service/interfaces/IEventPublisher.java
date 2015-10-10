package com.ai.common.rootentity.domain.service.interfaces;

import com.ai.common.rootentity.domain.model.interfaces.BaseEvent;


public interface IEventPublisher {
	void publishEvent(BaseEvent event);
}
