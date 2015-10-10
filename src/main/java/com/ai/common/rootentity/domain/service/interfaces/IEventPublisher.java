package com.ai.common.rootentity.domain.service.interfaces;

import com.ai.common.rootentity.domain.model.impl.BaseEvent;


public interface IEventPublisher {
	void publishEvent(BaseEvent event);
}
