package com.ai.common.rootentity.domain.service.interfaces;

import com.ai.common.bpmn.model.BaseEvent;


public interface IEventPublisher {
	void publishEvent(BaseEvent event);
}
