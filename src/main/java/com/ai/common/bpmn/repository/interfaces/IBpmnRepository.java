package com.ai.common.bpmn.repository.interfaces;

import java.util.Set;

import com.ai.common.bpmn.model.Activity;
import com.ai.common.bpmn.model.BaseEvent;

public interface IBpmnRepository {
	Set<Activity> getActivitiesByOutputEvent(BaseEvent event) throws Exception;
	
}
