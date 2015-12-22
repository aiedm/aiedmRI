package com.ai.common.bpmn.service.interfaces;

import com.ai.common.bpmn.model.BaseEvent;

public interface IBpmn {
	String getBpmnJsonString(BaseEvent startEvent,BaseEvent endEvent) throws Exception;
	String appendExclusiveGateway(BaseEvent toEvent)  throws Exception;
	
}
